package com.parking.infrastructure.persistence.repository.adapter.sql.jpa;

import com.parking.crosscuting.helper.UUIDHelper;
import com.parking.infrastructure.persistence.repository.TicketRepository;
import com.parking.infrastructure.persistence.repository.entity.TicketEntity;
import com.parking.infrastructure.persistence.repository.mapper.TicketPersistenceMapper;
import com.parking.infrastructure.persistence.repository.sql.jpa.TicketJPARepository;
import com.parking.infrastructure.persistence.repository.sql.jpa.entity.TicketJPAEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class TicketJPARepositoryAdapter implements TicketRepository {

    private final TicketJPARepository repository;
    private final TicketPersistenceMapper mapper;

    public TicketJPARepositoryAdapter(final TicketJPARepository repository,
                                       final TicketPersistenceMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void create(final TicketEntity entity) {
        TicketJPAEntity jpaEntity = mapper.toJPAEntity(entity);

        if (jpaEntity.getId().equals(UUIDHelper.getUUIDHelper().getDefault())) {
            jpaEntity.setId(UUID.randomUUID());
        }

        repository.save(jpaEntity);
    }

    @Override
    public List<TicketEntity> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDomainEntity)
                .toList();
    }

    @Override
    public List<TicketEntity> findByFilter(final TicketEntity filter) {
        // Para esta transacción findByFilter no se usa.
        // Se implementa con las queries específicas hasOpenTicket*.
        return List.of();
    }

    @Override
    public TicketEntity findById(final UUID id) {
        return repository.findById(id)
                .map(mapper::toDomainEntity)
                .orElse(null);
    }

    @Override
    public boolean hasOpenTicketByCellId(final UUID cellId) {
        return repository.hasOpenTicketByCellId(cellId);
    }

    @Override
    public boolean hasOpenTicketByVehicleId(final UUID vehicleId) {
        return repository.hasOpenTicketByVehicleId(vehicleId);
    }
}