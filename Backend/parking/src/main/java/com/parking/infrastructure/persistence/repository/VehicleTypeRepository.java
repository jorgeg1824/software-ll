package com.parking.infrastructure.persistence.repository;

import java.util.UUID;

import com.parking.infrastructure.persistence.repository.entity.VehicleTypeEntity;

public interface VehicleTypeRepository {
	
	void create(VehicleTypeEntity entity);
	
	void update(UUID id, VehicleTypeEntity entity);

}
