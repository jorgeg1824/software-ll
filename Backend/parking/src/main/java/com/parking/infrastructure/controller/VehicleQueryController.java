package com.parking.infrastructure.controller;

import com.parking.infrastructure.persistence.repository.adapter.sql.jpa.VehicleQueryService;
import com.parking.infrastructure.rest.dto.VehicleInfoResponse;
import com.parking.infrastructure.rest.dto.VehicleTypeInfoResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vehicles")
@Tag(name = "Vehículos", description = "Consulta de vehículos y tipos de vehículo")
public class VehicleQueryController {

    private final VehicleQueryService vehicleQueryService;

    public VehicleQueryController(final VehicleQueryService vehicleQueryService) {
        this.vehicleQueryService = vehicleQueryService;
    }

    @Operation(
            summary = "Buscar vehículo por placa",
            description = "Busca un vehículo registrado por su placa. Retorna 404 si no existe."
        )
        @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Vehículo encontrado"),
            @ApiResponse(responseCode = "404", description = "Vehículo no registrado")
        })
        @GetMapping("/plate/{plate}")
        public ResponseEntity<VehicleInfoResponse> findByPlate(
                @PathVariable final String plate) {
            return vehicleQueryService.findByLicensePlate(plate)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        }

        @Operation(
            summary = "Listar tipos de vehículo",
            description = "Retorna todos los tipos de vehículo activos disponibles."
        )
        @ApiResponse(responseCode = "200", description = "Lista de tipos de vehículo")
        @GetMapping("/types")
        public ResponseEntity<List<VehicleTypeInfoResponse>> findAllTypes() {
            return ResponseEntity.ok(vehicleQueryService.findAllVehicleTypes());
        }
    }