package com.parking.infrastructure.persistence.repository;

import java.util.List;
import java.util.UUID;

import com.parking.infrastructure.persistence.repository.entity.VehicleExitEntity;

public interface VehicleExitRepository {
	
	void create(VehicleExitEntity entity);
	
	List<VehicleExitEntity> findAll();
	
	List<VehicleExitEntity> findByFilter(VehicleExitEntity filter);
	
	VehicleExitEntity findById(UUID id);

}
