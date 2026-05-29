package com.parking.infrastructure.persistence.repository.sql.jpa.entity;

import java.util.UUID;

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
@Table(name = "Vehiculo")
public final class VehicleJPAEntity {
	
	@Id
	@Column(name = "id_vehiculo")
    private UUID id;
	
	@Column(name = "placa")
    private String licensePlate;
	
	@ManyToOne
	@JoinColumn(name = "id_tipo_vehiculo")
    private VehicleTypeJPAEntity vehicleType;

    public VehicleJPAEntity() {
        setId(UUIDHelper.getUUIDHelper().getDefault());
        setLicensePlate(TextHelper.getDefault());
        setVehicleType(new VehicleTypeJPAEntity());
    }

    public VehicleJPAEntity(final UUID id, final String licensePlate, final VehicleTypeJPAEntity vehicleType) {
        setId(id);
        setLicensePlate(licensePlate);
        setVehicleType(vehicleType);
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = UUIDHelper.getUUIDHelper().getDefault(id);
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(final String licensePlate) {
        this.licensePlate = TextHelper.getDefaultWithTrim(licensePlate);
    }

    public VehicleTypeJPAEntity getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(final VehicleTypeJPAEntity vehicleType) {
        this.vehicleType = ObjectHelper.getDefault(vehicleType, new VehicleTypeJPAEntity());
    }
}
