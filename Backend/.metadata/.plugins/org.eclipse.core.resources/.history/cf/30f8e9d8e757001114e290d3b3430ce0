package com.parking.infrastructure.persistence.repository.mapper;

import com.parking.infrastructure.persistence.repository.entity.VehicleEntity;
import com.parking.infrastructure.persistence.repository.sql.jpa.entity.VehicleJPAEntity;
import org.springframework.stereotype.Component;

@Component
public class VehiclePersistenceMapper {

    public VehicleEntity toDomainEntity(final VehicleJPAEntity jpaEntity) {
        if (jpaEntity == null) return null;

        VehicleEntity entity = new VehicleEntity();
        entity.setId(jpaEntity.getId());
        entity.setLicensePlate(jpaEntity.getLicensePlate());

        return entity;
    }
}