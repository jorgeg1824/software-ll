package com.parking.infrastructure.persistence.repository.sql.jpa.entity;

import java.util.UUID;

import com.parking.crosscuting.helper.ObjectHelper;
import com.parking.crosscuting.helper.UUIDHelper;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "CeldaVehiculo")
public final class CellVehicleJPAEntity {
	
	@Id
	@Column(name = "id_celda_vehiculo")
    private UUID id;
	
	@Column(name = "tarifa")
    private int rate;
	
	@ManyToOne
	@JoinColumn(name = "id_celda")
    private CellJPAEntity cell;
	
	@ManyToOne
	@JoinColumn(name = "id_vehiculo")
    private VehicleJPAEntity vehicle;

    public CellVehicleJPAEntity() {
        setId(UUIDHelper.getUUIDHelper().getDefault());
        setRate(0);
        setCell(new CellJPAEntity());
        setVehicle(new VehicleJPAEntity());
    }

    public CellVehicleJPAEntity(final UUID id, final int rate, final CellJPAEntity cell, final VehicleJPAEntity vehicle) {
        setId(id);
        setRate(rate);
        setCell(cell);
        setVehicle(vehicle);
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = UUIDHelper.getUUIDHelper().getDefault(id);
    }

    public int getRate() {
        return rate;
    }

    public void setRate(final int rate) {
        this.rate = rate;
    }

    public CellJPAEntity getCell() {
        return cell;
    }

    public void setCell(final CellJPAEntity cell) {
        this.cell = ObjectHelper.getDefault(cell, new CellJPAEntity());
    }

    public VehicleJPAEntity getVehicle() {
        return vehicle;
    }

    public void setVehicle(final VehicleJPAEntity vehicle) {
        this.vehicle = ObjectHelper.getDefault(vehicle, new VehicleJPAEntity());
    }
}
