package com.parking.infrastructure.persistence.repository.sql.jpa.entity;

import java.util.UUID;

import com.parking.crosscuting.helper.TextHelper;
import com.parking.crosscuting.helper.UUIDHelper;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "EstadoTicket")
public final class TicketStatusJPAEntity {
	
	@Id
	@Column(name = "id_estado")
    private UUID id;
	
	@Column(name = "nombre_estado")
    private String name;
	
	@Column(name = "descripcion_estado")
    private String description;

    public TicketStatusJPAEntity() {
        setId(UUIDHelper.getUUIDHelper().getDefault());
        setName(TextHelper.getDefault());
        setDescription(TextHelper.getDefault());
    }

    public TicketStatusJPAEntity(final UUID id, final String name, final String description) {
        setId(id);
        setName(name);
        setDescription(description);
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
}
