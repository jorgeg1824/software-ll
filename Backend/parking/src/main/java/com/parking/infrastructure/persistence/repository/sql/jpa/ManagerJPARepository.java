package com.parking.infrastructure.persistence.repository.sql.jpa;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parking.infrastructure.persistence.repository.sql.jpa.entity.ManagerJPAEntity;

public interface ManagerJPARepository extends JpaRepository<ManagerJPAEntity, UUID> {

}
