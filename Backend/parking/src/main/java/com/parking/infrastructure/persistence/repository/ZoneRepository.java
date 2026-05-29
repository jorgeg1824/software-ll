package com.parking.infrastructure.persistence.repository;

import java.util.List;
import java.util.UUID;

import com.parking.infrastructure.persistence.repository.entity.ZoneEntity;

public interface ZoneRepository {
	
	void create(ZoneEntity entity);
	
	void update(UUID id, ZoneEntity entity);
	
	List<ZoneEntity> findAll();
	
	List<ZoneEntity> findByFilter(ZoneEntity filter);

}
