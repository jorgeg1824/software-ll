package com.parking.infrastructure.persistence.repository;

import com.parking.infrastructure.persistence.repository.entity.TicketEntity;

import java.util.List;
import java.util.UUID;

public interface TicketRepository {

    void create(TicketEntity entity);

    List<TicketEntity> findAll();

    List<TicketEntity> findByFilter(TicketEntity filter);

    TicketEntity findById(UUID id);

    boolean hasOpenTicketByCellId(UUID cellId);

    boolean hasOpenTicketByVehicleId(UUID vehicleId);
}