package com.parking.infrastructure.persistence.repository.adapter.sql.jpa;

import com.parking.infrastructure.persistence.repository.CellRepository;
import com.parking.infrastructure.persistence.repository.entity.CellEntity;
import com.parking.infrastructure.persistence.repository.mapper.CellPersistenceMapper;
import com.parking.infrastructure.persistence.repository.sql.jpa.CellJPARepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class CellJPARepositoryAdapter implements CellRepository {

    private final CellJPARepository repository;
    private final CellPersistenceMapper mapper;

    public CellJPARepositoryAdapter(final CellJPARepository repository,
                                     final CellPersistenceMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public CellEntity findById(final UUID id) {
        return repository.findById(id)
                .map(mapper::toDomainEntity)
                .orElse(null);
    }

	@Override
	public void create(CellEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(UUID id, CellEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CellEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CellEntity> findByFilter(CellEntity filter) {
		// TODO Auto-generated method stub
		return null;
	}
}