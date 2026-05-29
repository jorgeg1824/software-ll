package com.parking.infrastructure.persistence.repository.mapper;

import org.springframework.stereotype.Component;

import com.parking.infrastructure.persistence.repository.entity.CellEntity;
import com.parking.infrastructure.persistence.repository.sql.jpa.entity.CellJPAEntity;
import com.parking.infrastructure.persistence.repository.sql.jpa.entity.CellTypeJPAEntity;
import com.parking.infrastructure.persistence.repository.sql.jpa.entity.ZoneJPAEntity;

@Component
public class CellPersistenceMapper {
	
	public CellJPAEntity toJPAEntity(final CellEntity entity) {
		
		if(entity == null) {
			return null;
		}
		
		CellJPAEntity jpaEntity = new CellJPAEntity();
		
		jpaEntity.setId(entity.getId());
		jpaEntity.setName(entity.getName());
		jpaEntity.setActive(entity.isActive());
		
		ZoneJPAEntity zoneJPAEntity = new ZoneJPAEntity();
		zoneJPAEntity.setId(entity.getZone().getId());
		jpaEntity.setZone(zoneJPAEntity);
		
		CellTypeJPAEntity cellTypeJPAEntity = new CellTypeJPAEntity();
		cellTypeJPAEntity.setId(entity.getCellType().getId());
		jpaEntity.setCellType(cellTypeJPAEntity);
		
		return jpaEntity;
	}
	
	public CellEntity toDomainEntity(final CellJPAEntity jpaEntity) {
	    if (jpaEntity == null) return null;
	    CellEntity entity = new CellEntity();
	    entity.setId(jpaEntity.getId());
	    entity.setName(jpaEntity.getName());
	    entity.setActive(jpaEntity.isActive());
	    return entity;
	}

}
