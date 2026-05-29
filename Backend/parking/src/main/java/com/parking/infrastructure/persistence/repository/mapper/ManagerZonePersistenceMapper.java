package com.parking.infrastructure.persistence.repository.mapper;

import org.springframework.stereotype.Component;

import com.parking.infrastructure.persistence.repository.entity.ManagerZoneEntity;
import com.parking.infrastructure.persistence.repository.sql.jpa.entity.ManagerJPAEntity;
import com.parking.infrastructure.persistence.repository.sql.jpa.entity.ManagerZoneJPAEntity;
import com.parking.infrastructure.persistence.repository.sql.jpa.entity.ZoneJPAEntity;

@Component
public class ManagerZonePersistenceMapper {
	
	public ManagerZoneJPAEntity toJPAEntity(final ManagerZoneEntity entity) {
		
		if (entity == null) {
            return null;
        }
		
		ManagerZoneJPAEntity jpaEntity = new ManagerZoneJPAEntity();
		
		jpaEntity.setId(entity.getId());
		jpaEntity.setAdministrationDate(entity.getAdministrationDate());
		
		ManagerJPAEntity managerJPAEntity = new ManagerJPAEntity();
		
		managerJPAEntity.setId(entity.getManager().getId());
		jpaEntity.setManager(managerJPAEntity);
		
		ZoneJPAEntity zoneJPAEntity = new ZoneJPAEntity();
		
		zoneJPAEntity.setId(entity.getZone().getId());
		jpaEntity.setZone(zoneJPAEntity);
		
		return jpaEntity;
	}

}
