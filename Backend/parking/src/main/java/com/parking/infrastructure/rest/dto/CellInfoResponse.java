package com.parking.infrastructure.rest.dto;

import java.util.UUID;

public record CellInfoResponse(
        UUID id,
        String name
) {}