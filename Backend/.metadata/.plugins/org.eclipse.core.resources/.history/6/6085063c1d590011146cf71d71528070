package com.parking.infrastructure.controller;

import com.parking.features.vehicle.addvehicle.application.inputport.AddVehicleInputPort;
import com.parking.features.vehicle.addvehicle.application.inputport.dto.AddVehicleResponseDTO;
import com.parking.infrastructure.rest.dto.AddVehicleRequest;
import com.parking.infrastructure.rest.dto.AddVehicleResponse;
import com.parking.infrastructure.rest.mapper.AddVehicleRestMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tickets")
@Tag(name = "Tickets", description = "Gestión de tickets de ingreso al parqueadero")
public class AddVehicleController {

    private final AddVehicleInputPort addVehicleInputPort;
    private final AddVehicleRestMapper addVehicleRestMapper;

    public AddVehicleController(final AddVehicleInputPort addVehicleInputPort,
                                 final AddVehicleRestMapper addVehicleRestMapper) {
        this.addVehicleInputPort = addVehicleInputPort;
        this.addVehicleRestMapper = addVehicleRestMapper;
    }

    @Operation(
        summary = "Registrar ingreso de vehículo",
        description = """
            Registra el ingreso de un vehículo al parqueadero y genera su ticket.
            
            Si el vehículo no existe en el sistema, se crea automáticamente
            con la placa y tipo de vehículo indicados.
            
            El ticket generado incluye: número de ticket, hora de ingreso,
            celda asignada y datos del vehículo.
            """
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "201",
            description = "Ticket generado exitosamente",
            content = @Content(schema = @Schema(implementation = AddVehicleResponse.class))
        ),
        @ApiResponse(
            responseCode = "400",
            description = "Datos de entrada inválidos (placa vacía, fecha futura, etc.)"
        ),
        @ApiResponse(
            responseCode = "409",
            description = "Conflicto: celda no disponible o vehículo ya dentro del parqueadero"
        )
    })
    @PostMapping("/entry")
    public ResponseEntity<AddVehicleResponse> registerEntry(
            @Valid @RequestBody final AddVehicleRequest request) {

        final AddVehicleResponseDTO result = addVehicleInputPort.execute(
                addVehicleRestMapper.toDTO(request)
        );
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(addVehicleRestMapper.toResponse(result));
    }
}