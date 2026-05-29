package com.parking.features.vehicle.addvehicle.application.usecase.domain;

import java.util.UUID;

import com.parking.crosscuting.helper.BooleanHelper;
import com.parking.crosscuting.helper.NumericHelper;
import com.parking.crosscuting.helper.TextHelper;
import com.parking.crosscuting.helper.UUIDHelper;

public final class VehicleTypeDomain extends Domain{
	
	private String name;
	private String description;
	private int rateApplied;
	private boolean isActive;
	
	public VehicleTypeDomain() {
		super(UUIDHelper.getUUIDHelper().getDefault());
		setName(TextHelper.getDefault());
		setDescription(TextHelper.getDefault());
		setRateApplied(NumericHelper.getDefault());
		setActive(BooleanHelper.getDefault());
	}
	
	public VehicleTypeDomain(final UUID id, final String name, final String description, final int rateApplied, final boolean isActive) {
		super(id);
		setName(name);
		setDescription(description);
		setRateApplied(rateApplied);
		setActive(isActive);
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
		this.description = TextHelper.getDefault(description);
	}
	public int getRateApplied() {
		return rateApplied;
	}
	public void setRateApplied(final int rateApplied) {
		this.rateApplied = NumericHelper.getDefault(rateApplied);
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(final boolean isActive) {
		this.isActive = BooleanHelper.getDefault(isActive);
	}

}
