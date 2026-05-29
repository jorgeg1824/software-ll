package com.parking.infrastructure.persistence.repository;

import java.util.List;
import java.util.UUID;

import com.parking.infrastructure.persistence.repository.entity.ManagerEntity;

public interface ManagerRepository {
	
	void create(ManagerEntity entity);
	
	void update(UUID id, ManagerEntity entity);
	
	List<ManagerEntity> findAll();
	
	List<ManagerEntity> findByFilter(ManagerEntity filter);
	
	ManagerEntity findById(UUID id);

}
