package com.parking.infrastructure.persistence.repository.sql.jpa;

import com.parking.infrastructure.persistence.repository.sql.jpa.entity.VehicleJPAEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface VehicleJPARepository extends JpaRepository<VehicleJPAEntity, UUID> {

    Optional<VehicleJPAEntity> findByLicensePlate(String licensePlate);
}