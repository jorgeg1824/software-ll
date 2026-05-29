package com.parking.infrastructure.controller;

import com.parking.infrastructure.persistence.repository.adapter.sql.jpa.VehicleQueryService;
import com.parking.infrastructure.rest.dto.VehicleInfoResponse;
import com.parking.infrastructure.rest.dto.VehicleTypeInfoResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vehicles")
public class VehicleQueryController {

    private final VehicleQueryService vehicleQueryService;

    public VehicleQueryController(final VehicleQueryService vehicleQueryService) {
        this.vehicleQueryService = vehicleQueryService;
    }

    @GetMapping("/plate/{plate}")
    public ResponseEntity<VehicleInfoResponse> findByPlate(
            @PathVariable final String plate) {
        return vehicleQueryService.findByLicensePlate(plate)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/types")
    public ResponseEntity<List<VehicleTypeInfoResponse>> findAllTypes() {
        return ResponseEntity.ok(vehicleQueryService.findAllVehicleTypes());
    }
}