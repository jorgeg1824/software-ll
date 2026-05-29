package com.parking.infrastructure.persistence.repository.sql.jpa.entity;

import java.util.UUID;

import com.parking.crosscuting.helper.BooleanHelper;
import com.parking.crosscuting.helper.TextHelper;
import com.parking.crosscuting.helper.UUIDHelper;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TipoVehiculo")
public final class VehicleTypeJPAEntity {
	
	@Id
	@Column(name = "id_tipo_vehiculo")
    private UUID id;
	
	@Column(name = "nombre_tipo_vehiculo")
    private String name;
	
	@Column(name = "descripcion")
    private String description;
	
	@Column(name = "tarifa_aplicada")
    private Integer rateApplied;
	
	@Column(name = "es_activo")
    private Boolean active;

    public VehicleTypeJPAEntity() {
        setId(UUIDHelper.getUUIDHelper().getDefault());
        setName(TextHelper.getDefault());
        setDescription(TextHelper.getDefault());
        setRateApplied(0);
        setActive(false);
    }

    public VehicleTypeJPAEntity(final UUID id, final String name, final String description, final int rateApplied, final boolean active) {
        setId(id);
        setName(name);
        setDescription(description);
        setRateApplied(rateApplied);
        setActive(active);
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = UUIDHelper.getUUIDHelper().getDefault(id);
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = TextHelper.getDefaultWithTrim(name);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = TextHelper.getDefaultWithTrim(description);
    }

    public Integer getRateApplied() {
        return rateApplied;
    }

    public void setRateApplied(final Integer rateApplied) {
        this.rateApplied = rateApplied;
    }

    public Boolean isActive() {
        return active;
    }

    public void setActive(final Boolean active) {
        this.active = BooleanHelper.getDefault(active);
    }
}
