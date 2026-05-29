package com.parking.infrastructure.persistence.repository;

import java.util.UUID;

import com.parking.infrastructure.persistence.repository.entity.CellTypeEntity;

public interface CellTypeRepository {
	
	void create(CellTypeEntity entity);
	
	void update(UUID id, CellTypeEntity entity);

}
