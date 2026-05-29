package com.parking.infrastructure.persistence.repository.sql.jpa.entity;

import com.parking.crosscuting.helper.UUIDHelper;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "ParametroCatalogo")
public final class ParametroCatalogoJPAEntity {

    @Id
    @Column(name = "id_parametro")
    private UUID id;

    @Column(name = "clave", nullable = false, unique = true)
    private String clave;

    @Column(name = "valor", nullable = false)
    private String valor;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "tipo_dato", nullable = false)
    private String tipoDato;

    @Column(name = "es_activo", nullable = false)
    private Boolean activo;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_actualizacion")
    private LocalDateTime fechaActualizacion;

    protected ParametroCatalogoJPAEntity() {}

    public UUID getId()                      { return id; }
    public String getClave()                 { return clave; }
    public String getValor()                 { return valor; }
    public String getDescripcion()           { return descripcion; }
    public String getTipoDato()              { return tipoDato; }
    public Boolean isActivo()               { return activo; }
    public LocalDateTime getFechaCreacion()  { return fechaCreacion; }

    public void setId(UUID id)                              { this.id = UUIDHelper.getUUIDHelper().getDefault(id); }
    public void setClave(String clave)                      { this.clave = clave; }
    public void setValor(String valor)                      { this.valor = valor; }
    public void setDescripcion(String descripcion)          { this.descripcion = descripcion; }
    public void setTipoDato(String tipoDato)                { this.tipoDato = tipoDato; }
    public void setActivo(Boolean activo)                   { this.activo = activo; }
    public void setFechaCreacion(LocalDateTime fecha)       { this.fechaCreacion = fecha; }
    public void setFechaActualizacion(LocalDateTime fecha)  { this.fechaActualizacion = fecha; }
}