package com.parking.infrastructure.persistence.repository.sql.jpa;

import com.parking.infrastructure.persistence.repository.sql.jpa.entity.ParametroCatalogoJPAEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ParametroCatalogoJPARepository
        extends JpaRepository<ParametroCatalogoJPAEntity, UUID> {

    List<ParametroCatalogoJPAEntity> findByActivoTrue();

    Optional<ParametroCatalogoJPAEntity> findByClaveAndActivoTrue(String clave);
}