package com.parking.infrastructure.persistence.repository.sql.jpa.entity;

import java.util.UUID;

import com.parking.crosscuting.helper.BooleanHelper;
import com.parking.crosscuting.helper.ObjectHelper;
import com.parking.crosscuting.helper.TextHelper;
import com.parking.crosscuting.helper.UUIDHelper;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Celda")
public final class CellJPAEntity {
	
	@Id
	@Column(name = "id_celda")
    private UUID id;
	
	@Column(name = "nombre_celda")
    private String name;
	
	@ManyToOne
	@JoinColumn(name = "id_tipo_celda")
    private CellTypeJPAEntity cellType;
	
	@ManyToOne
	@JoinColumn(name = "id_zona")
	private ZoneJPAEntity zone;
	
	@Column(name = "es_activo")
    private boolean active;

    public CellJPAEntity() {
        setId(UUIDHelper.getUUIDHelper().getDefault());
        setName(TextHelper.getDefault());
        setCellType(new CellTypeJPAEntity());
        setZone(new ZoneJPAEntity());
        setActive(false);
    }

    public CellJPAEntity(final UUID id, final String name, final CellTypeJPAEntity cellType, final ZoneJPAEntity zone, final boolean active) {
        setId(id);
        setName(name);
        setCellType(cellType);
        setZone(zone);
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

    public CellTypeJPAEntity getCellType() {
        return cellType;
    }

    public void setCellType(final CellTypeJPAEntity cellType) {
       this.cellType = ObjectHelper.getDefault(cellType, new CellTypeJPAEntity());
    }

    public ZoneJPAEntity getZone() {
        return zone;
    }

    public void setZone(final ZoneJPAEntity zone) {
        this.zone = ObjectHelper.getDefault(zone, new ZoneJPAEntity());
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(final boolean active) {
        this.active = BooleanHelper.getDefault(active);
    }

}
