package com.parking.infrastructure.rest.dto;

import java.util.UUID;

public record VehicleTypeInfoResponse(
        UUID id,
        String name
) {}