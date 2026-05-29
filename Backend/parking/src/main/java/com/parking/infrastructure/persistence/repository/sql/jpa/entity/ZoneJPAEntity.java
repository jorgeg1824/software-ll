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
@Table(name = "Zona")
public final class ZoneJPAEntity {
	
	@Id
	@Column(name = "id_zona")
    private UUID id;
	
	@Column(name = "nombre_zona")
    private String name;
	
	@Column(name = "descripcion")
    private String description;
	
	@Column(name = "es_activo")
    private boolean active;

    public ZoneJPAEntity() {
        setId(UUIDHelper.getUUIDHelper().getDefault());
        setName(TextHelper.getDefault());
        setDescription(TextHelper.getDefault());
        setActive(false);
    }

    public ZoneJPAEntity(final UUID id, final String name, final String description, final boolean active) {
        setId(id);
        setName(name);
        setDescription(description);
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

    public boolean isActive() {
        return active;
    }

    public void setActive(final boolean active) {
        this.active = BooleanHelper.getDefault(active);
    }

}
