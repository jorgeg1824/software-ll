package com.parking.infrastructure.persistence.repository.mapper;

import org.springframework.stereotype.Component;

import com.parking.infrastructure.persistence.repository.entity.CellTypeEntity;
import com.parking.infrastructure.persistence.repository.sql.jpa.entity.CellTypeJPAEntity;

@Component
public class CellTypePersistenceMapper {
	
	public CellTypeJPAEntity toJPAEntity(final CellTypeEntity entity) {
		
		if (entity == null) {
            return null;
        }
		
		CellTypeJPAEntity jpaEntity = new CellTypeJPAEntity();
		
		jpaEntity.setId(entity.getId());
		jpaEntity.setName(entity.getName());
		jpaEntity.setDescription(entity.getDescription());
		jpaEntity.setActive(entity.isActive());
		
		return jpaEntity;
	}

}
