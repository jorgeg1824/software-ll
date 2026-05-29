package com.parking.infrastructure.persistence.repository;

import com.parking.infrastructure.persistence.repository.entity.VehicleEntity;

import java.util.Optional;
import java.util.UUID;

public interface VehicleRepository {

    VehicleEntity findById(UUID id);

    Optional<VehicleEntity> findByLicensePlate(String licensePlate);

    VehicleEntity save(VehicleEntity vehicle);
}