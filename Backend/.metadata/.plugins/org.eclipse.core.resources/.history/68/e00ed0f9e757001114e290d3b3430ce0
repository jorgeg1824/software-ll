package com.parking.infrastructure.persistence.repository.adapter.sql.jpa;

import com.parking.infrastructure.persistence.repository.VehicleRepository;
import com.parking.infrastructure.persistence.repository.entity.VehicleEntity;
import com.parking.infrastructure.persistence.repository.mapper.VehiclePersistenceMapper;
import com.parking.infrastructure.persistence.repository.sql.jpa.VehicleJPARepository;
import org.springframework.stereotype.Component;

import java.util.List;
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
	public void create(VehicleEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(UUID id, VehicleEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<VehicleEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VehicleEntity> findByFilter(VehicleEntity filter) {
		// TODO Auto-generated method stub
		return null;
	}
}