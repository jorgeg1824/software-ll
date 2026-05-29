package com.parking.infrastructure.persistence.repository.mapper;

import org.springframework.stereotype.Component;

import com.parking.infrastructure.persistence.repository.entity.VehicleExitEntity;
import com.parking.infrastructure.persistence.repository.sql.jpa.entity.TicketJPAEntity;
import com.parking.infrastructure.persistence.repository.sql.jpa.entity.VehicleExitJPAEntity;

@Component
public class VehicleExitPersistenceMapper {
	
	public VehicleExitJPAEntity toJPAEntity(final VehicleExitEntity entity) {
		
		if (entity == null) {
            return null;
        }
		
		VehicleExitJPAEntity jpaEntity = new VehicleExitJPAEntity();
		
		jpaEntity.setId(entity.getId());
		jpaEntity.setExitDate(entity.getExitDate());
		jpaEntity.setStayDuration(entity.getStayDuration());
		jpaEntity.setTotalAmount(entity.getTotalAmount());
		
		TicketJPAEntity ticketJPAEntity = new TicketJPAEntity();
		
		ticketJPAEntity.setId(entity.getTicket().getId());
		jpaEntity.setTicket(ticketJPAEntity);
		
		return jpaEntity;
	}

}
