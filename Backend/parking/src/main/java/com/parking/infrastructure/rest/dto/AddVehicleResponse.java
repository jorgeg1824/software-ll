package com.parking.infrastructure.rest.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public class AddVehicleResponse {

    private UUID id;
    private int ticketNumber;
    private LocalDateTime entryDate;
    private UUID cellVehicle;

    public AddVehicleResponse(UUID id, int ticketNumber,
                               LocalDateTime entryDate, UUID cellVehicle) {
        this.id = id;
        this.ticketNumber = ticketNumber;
        this.entryDate = entryDate;
        this.cellVehicle = cellVehicle;
    }

    public UUID getId() { return id; }
    public int getTicketNumber() { return ticketNumber; }
    public LocalDateTime getEntryDate() { return entryDate; }
    public UUID getCellVehicle() { return cellVehicle; }
}