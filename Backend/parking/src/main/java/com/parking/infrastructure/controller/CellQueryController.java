package com.parking.infrastructure.controller;

import com.parking.infrastructure.persistence.repository.adapter.sql.jpa.CellQueryService;
import com.parking.infrastructure.rest.dto.CellInfoResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cells")
@Tag(name = "Celdas", description = "Consulta de celdas disponibles en el parqueadero")
public class CellQueryController {

    private final CellQueryService cellQueryService;

    public CellQueryController(final CellQueryService cellQueryService) {
        this.cellQueryService = cellQueryService;
    }

    @Operation(
            summary = "Listar celdas disponibles",
            description = "Retorna las celdas activas que no tienen un ticket abierto."
        )
        @ApiResponse(responseCode = "200", description = "Lista de celdas disponibles")
        @GetMapping("/available")
        public ResponseEntity<List<CellInfoResponse>> findAvailable() {
            return ResponseEntity.ok(cellQueryService.findAvailableCells());
        }
    }