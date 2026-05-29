package com.parking.infrastructure.persistence.repository.mapper;

import org.springframework.stereotype.Component;

import com.parking.infrastructure.persistence.repository.entity.VehicleTypeEntity;
import com.parking.infrastructure.persistence.repository.sql.jpa.entity.VehicleTypeJPAEntity;

@Component
public class VehicleTypePersistenceMapper {
	
	public VehicleTypeJPAEntity toJPAEntity(final VehicleTypeEntity entity) {
		
		if (entity == null) {
            return null;
        }
		
		VehicleTypeJPAEntity jpaEntity = new VehicleTypeJPAEntity();
		
		jpaEntity.setId(entity.getId());
		jpaEntity.setName(entity.getName());
		jpaEntity.setDescription(entity.getDescription());
		jpaEntity.setRateApplied(entity.getRateApplied());
		jpaEntity.setActive(entity.isActive());
		
		return jpaEntity;
	}

}
