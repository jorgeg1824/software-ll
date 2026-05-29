package com.parking.infrastructure.persistence.repository.adapter.sql.jpa;

import com.parking.infrastructure.persistence.repository.sql.jpa.ParametroCatalogoJPARepository;
import com.parking.infrastructure.rest.dto.ParameterCatalogResponse;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ParameterCatalogQueryService {

    private final ParametroCatalogoJPARepository repository;

    public ParameterCatalogQueryService(
            final ParametroCatalogoJPARepository repository) {
        this.repository = repository;
    }

    @Cacheable("parametros")
    public List<ParameterCatalogResponse> findAll() {
        return repository.findByActivoTrue()
                .stream()
                .map(p -> new ParameterCatalogResponse(
                        p.getId(),
                        p.getClave(),
                        p.getValor(),
                        p.getDescripcion(),
                        p.getTipoDato()
                ))
                .toList();
    }
 
    @Cacheable(value = "parametro", key = "#clave")
    public Optional<String> getValueByKey(final String clave) {
        return repository.findByClaveAndActivoTrue(clave)
                .map(p -> p.getValor());
    }
}