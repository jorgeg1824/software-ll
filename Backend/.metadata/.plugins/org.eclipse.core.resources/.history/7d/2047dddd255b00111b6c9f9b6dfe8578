package com.parking.infrastructure.persistence.repository.sql.jpa.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "CatalogoNotificacion")
public final class CatalogoNotificacionJPAEntity {

    @Id
    @Column(name = "id_notificacion")
    private UUID id;

    @Column(name = "codigo", nullable = false, unique = true)
    private String codigo;

    @Column(name = "canal")
    private String canal;

    @Column(name = "asunto_es")
    private String asuntoEs;

    @Column(name = "asunto_en")
    private String asuntoEn;

    @Column(name = "cuerpo_es", nullable = false)
    private String cuerpoEs;

    @Column(name = "cuerpo_en", nullable = false)
    private String cuerpoEn;

    @Column(name = "es_activo")
    private Boolean activo;

    protected CatalogoNotificacionJPAEntity() {}

    public UUID getId()         { return id; }
    public String getCodigo()   { return codigo; }
    public String getCanal()    { return canal; }
    public String getAsuntoEs() { return asuntoEs; }
    public String getAsuntoEn() { return asuntoEn; }
    public String getCuerpoEs() { return cuerpoEs; }
    public String getCuerpoEn() { return cuerpoEn; }
    public Boolean isActivo()   { return activo; }
}