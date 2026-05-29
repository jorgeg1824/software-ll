package com.parking.infrastructure.persistence.repository.mapper;

import com.parking.infrastructure.persistence.repository.entity.CellVehicleEntity;
import com.parking.infrastructure.persistence.repository.entity.TicketEntity;
import com.parking.infrastructure.persistence.repository.entity.TicketStatusEntity;
import com.parking.infrastructure.persistence.repository.sql.jpa.entity.CellVehicleJPAEntity;
import com.parking.infrastructure.persistence.repository.sql.jpa.entity.TicketJPAEntity;
import com.parking.infrastructure.persistence.repository.sql.jpa.entity.TicketStatusJPAEntity;
import org.springframework.stereotype.Component;

@Component
public class TicketPersistenceMapper {

    public TicketJPAEntity toJPAEntity(final TicketEntity entity) {
        if (entity == null) return null;

        CellVehicleJPAEntity cellVehicleJPA = new CellVehicleJPAEntity();
        cellVehicleJPA.setId(entity.getCellVehicle().getId());

        TicketStatusJPAEntity statusJPA = new TicketStatusJPAEntity();
        statusJPA.setId(entity.getTicketStatus().getId());

        return new TicketJPAEntity(
                entity.getId(),
                entity.getTicketNumber(),
                entity.getEntryDate(),
                cellVehicleJPA,
                statusJPA
        );
    }

    public TicketEntity toDomainEntity(final TicketJPAEntity jpaEntity) {
        if (jpaEntity == null) return null;

        CellVehicleEntity cellVehicle = new CellVehicleEntity();
        cellVehicle.setId(jpaEntity.getCellVehicle().getId());

        TicketStatusEntity ticketStatus = new TicketStatusEntity();
        ticketStatus.setId(jpaEntity.getTicketStatus().getId());

        return new TicketEntity(
                jpaEntity.getId(),
                jpaEntity.getTicketNumber(),
                jpaEntity.getEntryDate(),
                cellVehicle,
                ticketStatus
        );
    }
}