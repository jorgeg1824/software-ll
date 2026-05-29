package com.parking.infrastructure.config;

import com.parking.infrastructure.persistence.repository.sql.jpa.CellJPARepository;

import org.springframework.boot.health.contributor.Health;
import org.springframework.boot.health.contributor.HealthIndicator;
import org.springframework.stereotype.Component;

@Component("parkingCapacity")
public class ParkingHealthIndicator implements HealthIndicator {

    private final CellJPARepository cellRepository;

    public ParkingHealthIndicator(final CellJPARepository cellRepository) {
        this.cellRepository = cellRepository;
    }

    @Override
    public Health health() {
        try {
            long totalCells = cellRepository.count();
            long activeCells = cellRepository.findAll()
                    .stream()
                    .filter(c -> Boolean.TRUE.equals(c.isActive()))
                    .count();

            if (activeCells == 0) {
                return Health.down()
                        .withDetail("message", "No hay celdas activas en el sistema")
                        .withDetail("totalCells", totalCells)
                        .build();
            }

            return Health.up()
                    .withDetail("totalCells", totalCells)
                    .withDetail("activeCells", activeCells)
                    .build();

        } catch (Exception e) {
            return Health.down()
                    .withDetail("error", e.getMessage())
                    .build();
        }
    }
}