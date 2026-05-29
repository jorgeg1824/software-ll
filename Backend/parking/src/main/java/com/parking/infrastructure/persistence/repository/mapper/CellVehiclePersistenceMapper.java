package com.parking.infrastructure.persistence.repository.mapper;

import com.parking.infrastructure.persistence.repository.entity.CellEntity;
import com.parking.infrastructure.persistence.repository.entity.CellVehicleEntity;
import com.parking.infrastructure.persistence.repository.entity.VehicleEntity;
import com.parking.infrastructure.persistence.repository.sql.jpa.entity.CellJPAEntity;
import com.parking.infrastructure.persistence.repository.sql.jpa.entity.CellVehicleJPAEntity;
import com.parking.infrastructure.persistence.repository.sql.jpa.entity.VehicleJPAEntity;
import org.springframework.stereotype.Component;

@Component
public class CellVehiclePersistenceMapper {

    public CellVehicleJPAEntity toJPAEntity(final CellVehicleEntity entity) {
        if (entity == null) return null;

        CellJPAEntity cellJPA = new CellJPAEntity();
        cellJPA.setId(entity.getCell().getId());

        VehicleJPAEntity vehicleJPA = new VehicleJPAEntity();
        vehicleJPA.setId(entity.getVehicle().getId());

        return new CellVehicleJPAEntity(
                entity.getId(),
                entity.getRate(),
                cellJPA,
                vehicleJPA
        );
    }

    public CellVehicleEntity toDomainEntity(final CellVehicleJPAEntity jpaEntity) {
        if (jpaEntity == null) return null;

        CellEntity cell = new CellEntity();
        cell.setId(jpaEntity.getCell().getId());

        VehicleEntity vehicle = new VehicleEntity();
        vehicle.setId(jpaEntity.getVehicle().getId());

        return new CellVehicleEntity(
                jpaEntity.getId(),
                jpaEntity.getRate(),
                cell,
                vehicle
        );
    }
}