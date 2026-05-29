package com.parking.features.vehicle.addvehicle.application.usecase.domain;

import java.util.UUID;

import com.parking.crosscuting.helper.BooleanHelper;
import com.parking.crosscuting.helper.ObjectHelper;
import com.parking.crosscuting.helper.TextHelper;
import com.parking.crosscuting.helper.UUIDHelper;

public final class CellDomain extends Domain{
	
	private String name;
	private CellTypeDomain cellType;
	private ZoneDomain zone;
	private boolean isActive;
	
	public CellDomain() {
		super(UUIDHelper.getUUIDHelper().getDefault());
		setName(TextHelper.getDefault());
		setCellType(new CellTypeDomain());
		setZone(new ZoneDomain());
		setActive(BooleanHelper.getDefault());
	}
	
	public CellDomain(final UUID id, final String name, final CellTypeDomain cellType, final ZoneDomain zone, final boolean isActive) {
		super(id);
		setName(name);
		setCellType(cellType);
		setZone(zone);
		setActive(isActive);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(final String name) {
		this.name = TextHelper.getDefaultWithTrim(name);
	}
	
	public CellTypeDomain getCellType() {
		return cellType;
	}
	
	public void setCellType(CellTypeDomain cellType) {
		this.cellType = ObjectHelper.getDefault(cellType, new CellTypeDomain());
	}
	
	public ZoneDomain getZone() {
		return zone;
	}
	
	public void setZone(ZoneDomain zone) {
		this.zone = ObjectHelper.getDefault(zone, new ZoneDomain());
	}
	
	public boolean isActive() {
		return isActive;
	}
	
	public void setActive(boolean isActive) {
		this.isActive = BooleanHelper.getDefault(isActive);
	}
	
}
