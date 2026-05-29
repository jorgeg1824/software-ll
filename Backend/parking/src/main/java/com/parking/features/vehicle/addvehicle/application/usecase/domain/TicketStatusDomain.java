package com.parking.features.vehicle.addvehicle.application.usecase.domain;

import java.util.UUID;

import com.parking.crosscuting.helper.TextHelper;
import com.parking.crosscuting.helper.UUIDHelper;

public final class TicketStatusDomain extends Domain{
	
	private String name;
	private String description;
	
	public TicketStatusDomain() {
		super(UUIDHelper.getUUIDHelper().getDefault());
		setName(TextHelper.getDefault());
		setDescription(TextHelper.getDefault());
	}
	
	public TicketStatusDomain(final UUID id, final String name, final String description) {
		super(id);
		setName(name);
		setDescription(description);
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
	public void setDescription(String description) {
		this.description = TextHelper.getDefault(description);
	}

}
