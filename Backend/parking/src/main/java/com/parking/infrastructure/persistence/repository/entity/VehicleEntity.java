package com.parking.infrastructure.persistence.repository.entity;

import com.parking.crosscuting.helper.UUIDHelper;

import java.util.UUID;

public final class VehicleEntity {

    private UUID id;
    private String licensePlate;
    private UUID vehicleTypeId;     

    public VehicleEntity() {
        setId(UUIDHelper.getUUIDHelper().getDefault());
    }

    public UUID getId()              { return id; }
    public String getLicensePlate()  { return licensePlate; }
    public UUID getVehicleTypeId()   { return vehicleTypeId; }

    public void setId(UUID id) {
        this.id = UUIDHelper.getUUIDHelper().getDefault(id);
    }
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
    public void setVehicleTypeId(UUID vehicleTypeId) {
        this.vehicleTypeId = vehicleTypeId;
    }
}