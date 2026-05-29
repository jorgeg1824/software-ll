package com.parking.infrastructure.persistence.repository.sql.jpa;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parking.infrastructure.persistence.repository.sql.jpa.entity.TicketStatusJPAEntity;

public interface TicketStatusJPARepository extends JpaRepository<TicketStatusJPAEntity, UUID> {

}
