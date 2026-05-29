package com.parking.infrastructure.controller;

import com.parking.infrastructure.persistence.repository.adapter.sql.jpa.CellQueryService;
import com.parking.infrastructure.rest.dto.CellInfoResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cells")
public class CellQueryController {

    private final CellQueryService cellQueryService;

    public CellQueryController(final CellQueryService cellQueryService) {
        this.cellQueryService = cellQueryService;
    }

    @GetMapping("/available")
    public ResponseEntity<List<CellInfoResponse>> findAvailable() {
        return ResponseEntity.ok(cellQueryService.findAvailableCells());
    }
}