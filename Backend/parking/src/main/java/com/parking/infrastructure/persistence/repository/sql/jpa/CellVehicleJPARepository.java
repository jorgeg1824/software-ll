package com.parking.infrastructure.persistence.repository.sql.jpa;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parking.infrastructure.persistence.repository.sql.jpa.entity.CellVehicleJPAEntity;

public interface CellVehicleJPARepository extends JpaRepository<CellVehicleJPAEntity, UUID> {

}
