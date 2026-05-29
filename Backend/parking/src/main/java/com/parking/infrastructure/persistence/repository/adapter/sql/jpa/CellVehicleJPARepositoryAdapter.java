package com.parking.infrastructure.persistence.repository.adapter.sql.jpa;

import com.parking.crosscuting.helper.UUIDHelper;
import com.parking.infrastructure.persistence.repository.CellVehicleRepository;
import com.parking.infrastructure.persistence.repository.entity.CellVehicleEntity;
import com.parking.infrastructure.persistence.repository.mapper.CellVehiclePersistenceMapper;
import com.parking.infrastructure.persistence.repository.sql.jpa.CellVehicleJPARepository;
import com.parking.infrastructure.persistence.repository.sql.jpa.entity.CellVehicleJPAEntity;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class CellVehicleJPARepositoryAdapter implements CellVehicleRepository {

    private final CellVehicleJPARepository repository;
    private final CellVehiclePersistenceMapper mapper;

    public CellVehicleJPARepositoryAdapter(final CellVehicleJPARepository repository,
                                            final CellVehiclePersistenceMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public CellVehicleEntity save(final CellVehicleEntity entity) {
        CellVehicleJPAEntity jpaEntity = mapper.toJPAEntity(entity);

        if (jpaEntity.getId().equals(UUIDHelper.getUUIDHelper().getDefault())) {
            jpaEntity.setId(UUID.randomUUID());
        }

        CellVehicleJPAEntity saved = repository.save(jpaEntity);
        return mapper.toDomainEntity(saved);
    }
}