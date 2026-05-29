package com.parking.infrastructure.persistence.repository;

import com.parking.infrastructure.persistence.repository.entity.CellVehicleEntity;

public interface CellVehicleRepository {

	CellVehicleEntity save(CellVehicleEntity entity);

}