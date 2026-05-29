package com.parking.infrastructure.persistence.repository.mapper;

import org.springframework.stereotype.Component;

import com.parking.infrastructure.persistence.repository.entity.TicketStatusEntity;
import com.parking.infrastructure.persistence.repository.sql.jpa.entity.TicketStatusJPAEntity;

@Component
public class TicketStatusPersistenceMapper {
	
	public TicketStatusJPAEntity toJPAEntity(final TicketStatusEntity entity) {
		
		if (entity == null) {
            return null;
        }
		
		TicketStatusJPAEntity jpaEntity = new TicketStatusJPAEntity();
		
		jpaEntity.setId(entity.getId());
		jpaEntity.setName(entity.getName());
		jpaEntity.setDescription(entity.getDescription());
		
		return jpaEntity;
	}

}
