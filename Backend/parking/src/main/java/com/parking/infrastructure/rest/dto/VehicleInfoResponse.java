package com.parking.infrastructure.rest.dto;

import java.util.UUID;

public record VehicleInfoResponse(
        UUID id,
        String licensePlate,
        UUID vehicleTypeId,   
        String vehicleTypeName
) {}