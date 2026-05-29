package com.parking.infrastructure.persistence.repository.sql.jpa;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parking.infrastructure.persistence.repository.sql.jpa.entity.CellTypeJPAEntity;

public interface CellTypeJPARepository extends JpaRepository<CellTypeJPAEntity, UUID> {

}
