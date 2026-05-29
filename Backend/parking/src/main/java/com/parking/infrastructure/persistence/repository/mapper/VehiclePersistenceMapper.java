package com.parking.infrastructure.persistence.repository.mapper;

import com.parking.infrastructure.persistence.repository.entity.VehicleEntity;
import com.parking.infrastructure.persistence.repository.sql.jpa.entity.VehicleJPAEntity;
import com.parking.infrastructure.persistence.repository.sql.jpa.entity.VehicleTypeJPAEntity;
import org.springframework.stereotype.Component;

@Component
public class VehiclePersistenceMapper {

    public VehicleEntity toDomainEntity(final VehicleJPAEntity jpaEntity) {
        if (jpaEntity == null) return null;
        VehicleEntity entity = new VehicleEntity();
        entity.setId(jpaEntity.getId());
        entity.setLicensePlate(jpaEntity.getLicensePlate());
        if (jpaEntity.getVehicleType() != null) {
            entity.setVehicleTypeId(jpaEntity.getVehicleType().getId());
        }
        return entity;
    }

    public VehicleJPAEntity toJPAEntity(final VehicleEntity entity) {
        if (entity == null) return null;
        VehicleTypeJPAEntity vehicleType = new VehicleTypeJPAEntity();
        vehicleType.setId(entity.getVehicleTypeId());
        return new VehicleJPAEntity(
                entity.getId(),
                entity.getLicensePlate(),
                vehicleType
        );
    }
}