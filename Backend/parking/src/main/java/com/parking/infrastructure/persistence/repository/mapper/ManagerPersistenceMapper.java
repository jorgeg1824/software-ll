package com.parking.infrastructure.persistence.repository.mapper;

import org.springframework.stereotype.Component;

import com.parking.infrastructure.persistence.repository.entity.ManagerEntity;
import com.parking.infrastructure.persistence.repository.sql.jpa.entity.ManagerJPAEntity;

@Component
public class ManagerPersistenceMapper {
	
	public ManagerJPAEntity toJPAEntity(final ManagerEntity entity) {
		
		if (entity == null) {
            return null;
        }
		
		ManagerJPAEntity jpaEntity = new ManagerJPAEntity();
		
		jpaEntity.setId(entity.getId());
		jpaEntity.setDocumentNumber(entity.getDocumentNumber());
		jpaEntity.setName(entity.getName());
		jpaEntity.setFirstSurname(entity.getFirstSurname());
		jpaEntity.setSecondSurname(entity.getSecondSurname());
		jpaEntity.setEmail(entity.getEmail());
		jpaEntity.setPhoneNumber(entity.getPhoneNumber());
		jpaEntity.setEmailConfirmed(entity.isEmailConfirmed());
		jpaEntity.setPhoneConfirmed(entity.isPhoneConfirmed());
		jpaEntity.setActive(entity.isActive());
		
		return jpaEntity;
	}

}
