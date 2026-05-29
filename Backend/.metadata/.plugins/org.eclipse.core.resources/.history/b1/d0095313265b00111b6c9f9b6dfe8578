package com.parking.infrastructure.persistence.repository.sql.jpa;

import com.parking.infrastructure.persistence.repository.sql.jpa.entity.CatalogoNotificacionJPAEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CatalogoNotificacionJPARepository
        extends JpaRepository<CatalogoNotificacionJPAEntity, UUID> {

    Optional<CatalogoNotificacionJPAEntity> findByCodigoAndActivoTrue(String codigo);
}