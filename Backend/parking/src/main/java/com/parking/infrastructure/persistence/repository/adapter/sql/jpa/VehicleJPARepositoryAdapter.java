package com.parking.infrastructure.persistence.repository.adapter.sql.jpa;

import com.parking.crosscuting.helper.UUIDHelper;
import com.parking.infrastructure.persistence.repository.VehicleRepository;
import com.parking.infrastructure.persistence.repository.entity.VehicleEntity;
import com.parking.infrastructure.persistence.repository.mapper.VehiclePersistenceMapper;
import com.parking.infrastructure.persistence.repository.sql.jpa.VehicleJPARepository;
import com.parking.infrastructure.persistence.repository.sql.jpa.entity.VehicleJPAEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class VehicleJPARepositoryAdapter implements VehicleRepository {

    private final VehicleJPARepository repository;
    private final VehiclePersistenceMapper mapper;

    public VehicleJPARepositoryAdapter(final VehicleJPARepository repository,
                                        final VehiclePersistenceMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public VehicleEntity findById(final UUID id) {
        return repository.findById(id)
                .map(mapper::toDomainEntity)
                .orElse(null);
    }

    @Override
    public Optional<VehicleEntity> findByLicensePlate(final String licensePlate) {
        return repository.findByLicensePlate(licensePlate)
                .map(mapper::toDomainEntity);
    }

    @Override
    public VehicleEntity save(final VehicleEntity vehicle) {
        VehicleJPAEntity jpaEntity = mapper.toJPAEntity(vehicle);

        if (jpaEntity.getId().equals(UUIDHelper.getUUIDHelper().getDefault())) {
            jpaEntity.setId(UUID.randomUUID());
        }

        VehicleJPAEntity saved = repository.save(jpaEntity);
        return mapper.toDomainEntity(saved);
    }
}