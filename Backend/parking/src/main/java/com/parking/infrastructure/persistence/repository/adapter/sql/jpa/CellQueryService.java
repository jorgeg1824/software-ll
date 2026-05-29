package com.parking.infrastructure.persistence.repository.adapter.sql.jpa;

import com.parking.infrastructure.persistence.repository.sql.jpa.CellJPARepository;
import com.parking.infrastructure.rest.dto.CellInfoResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class CellQueryService {

    private final CellJPARepository cellRepository;

    public CellQueryService(final CellJPARepository cellRepository) {
        this.cellRepository = cellRepository;
    }

    public List<CellInfoResponse> findAvailableCells() {
        return cellRepository.findAvailableCells()
                .stream()
                .map(c -> new CellInfoResponse(c.getId(), c.getName()))
                .toList();
    }
}