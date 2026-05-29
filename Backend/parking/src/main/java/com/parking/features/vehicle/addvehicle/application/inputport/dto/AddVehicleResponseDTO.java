package com.parking.features.vehicle.addvehicle.application.inputport.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public class AddVehicleResponseDTO {

    private UUID id;
    private int ticketNumber;
    private LocalDateTime entryDate;
    private UUID cellVehicle;
    private UUID ticketStatus;

    public AddVehicleResponseDTO(UUID id, int ticketNumber, LocalDateTime entryDate,
                                  UUID cellVehicle, UUID ticketStatus) {
        this.id = id;
        this.ticketNumber = ticketNumber;
        this.entryDate = entryDate;
        this.cellVehicle = cellVehicle;
        this.ticketStatus = ticketStatus;
    }

    public UUID getId() { return id; }
    public int getTicketNumber() { return ticketNumber; }
    public LocalDateTime getEntryDate() { return entryDate; }
    public UUID getCellVehicle() { return cellVehicle; }
    public UUID getTicketStatus() { return ticketStatus; }
}