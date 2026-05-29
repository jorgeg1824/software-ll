package com.parking.infrastructure.persistence.repository.mapper;

import org.springframework.stereotype.Component;

import com.parking.infrastructure.persistence.repository.entity.ZoneEntity;
import com.parking.infrastructure.persistence.repository.sql.jpa.entity.ZoneJPAEntity;

@Component
public class ZonePersistenceMapper {
	
	public ZoneJPAEntity toJPAEntity(final ZoneEntity entity) {
		
		if (entity == null) {
            return null;
        }
		
		ZoneJPAEntity jpaEntity = new ZoneJPAEntity();
		
		jpaEntity.setId(entity.getId());
		jpaEntity.setName(entity.getName());
		jpaEntity.setDescription(entity.getDescription());
		jpaEntity.setActive(entity.isActive());
		
		return jpaEntity;
	}

}
