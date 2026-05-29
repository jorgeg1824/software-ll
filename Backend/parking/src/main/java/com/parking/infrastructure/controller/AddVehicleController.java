package com.parking.infrastructure.controller;

import com.parking.features.vehicle.addvehicle.application.inputport.AddVehicleInputPort;
import com.parking.features.vehicle.addvehicle.application.inputport.dto.AddVehicleResponseDTO;
import com.parking.infrastructure.persistence.repository.adapter.sql.jpa.NotificationService;
import com.parking.infrastructure.rest.dto.AddVehicleRequest;
import com.parking.infrastructure.rest.dto.AddVehicleResponse;
import com.parking.infrastructure.rest.mapper.AddVehicleRestMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/tickets")
@Tag(name = "Tickets", description = "Gestión de tickets de ingreso al parqueadero")
public class AddVehicleController {

    private final AddVehicleInputPort  addVehicleInputPort;
    private final AddVehicleRestMapper addVehicleRestMapper;
    private final NotificationService  notificationService;

    public AddVehicleController(
            final AddVehicleInputPort addVehicleInputPort,
            final AddVehicleRestMapper addVehicleRestMapper,
            final NotificationService notificationService) {
        this.addVehicleInputPort  = addVehicleInputPort;
        this.addVehicleRestMapper = addVehicleRestMapper;
        this.notificationService  = notificationService;
    }

    @Operation(
        summary = "Registrar ingreso de vehículo",
        description = "Registra el ingreso, genera el ticket y envía notificación por email."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Ticket generado exitosamente"),
        @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos"),
        @ApiResponse(responseCode = "409", description = "Celda ocupada o vehículo ya dentro")
    })
    @PostMapping("/entry")
    public ResponseEntity<AddVehicleResponse> registerEntry(
            @Valid @RequestBody final AddVehicleRequest request,
            @RequestHeader(value = "Accept-Language", defaultValue = "es") String lang,
            @RequestHeader(value = "X-User-Email", required = false) String userEmail) {

        final AddVehicleResponseDTO result = addVehicleInputPort.execute(
                addVehicleRestMapper.toDTO(request)
        );

        if (userEmail != null && !userEmail.isBlank()) {
        	notificationService.sendTicketNotification(
        		    userEmail,
        		    Map.of(
        		        "ticketNumber", String.valueOf(result.getTicketNumber()),
        		        "entryTime",    result.getEntryDate()
        		                             .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")),
        		        "cellName",     request.getCellName() != null
        		                            ? request.getCellName()
        		                            : "N/A"
        		    ),
        		    lang
        		);
        }

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(addVehicleRestMapper.toResponse(result));
    }
}