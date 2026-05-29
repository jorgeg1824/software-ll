package com.parking.infrastructure.persistence.repository.entity;

import java.util.UUID;

import com.parking.crosscuting.helper.ObjectHelper;
import com.parking.crosscuting.helper.UUIDHelper;

public final class CellVehicleEntity {

    private UUID id;
    private int rate;
    private CellEntity cell;
    private VehicleEntity vehicle;

    public CellVehicleEntity() {
        setId(UUIDHelper.getUUIDHelper().getDefault());
        setRate(0);
        setCell(new CellEntity());
        setVehicle(new VehicleEntity());
    }

    public CellVehicleEntity(final UUID id, final int rate, final CellEntity cell, final VehicleEntity vehicle) {
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

    public CellEntity getCell() {
        return cell;
    }

    public void setCell(final CellEntity cell) {
        this.cell = ObjectHelper.getDefault(cell, new CellEntity());
    }

    public VehicleEntity getVehicle() {
        return vehicle;
    }

    public void setVehicle(final VehicleEntity vehicle) {
        this.vehicle = ObjectHelper.getDefault(vehicle, new VehicleEntity());
    }
}
