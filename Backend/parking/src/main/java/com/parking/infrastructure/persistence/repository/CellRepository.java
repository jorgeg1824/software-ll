package com.parking.infrastructure.persistence.repository;

import java.util.List;
import java.util.UUID;

import com.parking.infrastructure.persistence.repository.entity.CellEntity;

public interface CellRepository {
	
	void create(CellEntity entity);
	
	void update(UUID id, CellEntity entity);
	
	List<CellEntity> findAll();
	
	List<CellEntity> findByFilter(CellEntity filter);
	
	CellEntity findById(UUID id);

}
