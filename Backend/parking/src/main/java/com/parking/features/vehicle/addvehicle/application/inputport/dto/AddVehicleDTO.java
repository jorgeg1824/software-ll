package com.parking.features.vehicle.addvehicle.application.inputport.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public class AddVehicleDTO {

    private UUID id;
    private int ticketNumber;
    private LocalDateTime entryDate;
    private String licensePlate;   
    private UUID vehicleTypeId;    
    private UUID cellId;
    private UUID ticketStatus;

    public AddVehicleDTO(final UUID id, final int ticketNumber,
                          final LocalDateTime entryDate, final String licensePlate,
                          final UUID vehicleTypeId, final UUID cellId,
                          final UUID ticketStatus) {
        this.id = id;
        this.ticketNumber = ticketNumber;
        this.entryDate = entryDate;
        this.licensePlate = licensePlate;
        this.vehicleTypeId = vehicleTypeId;
        this.cellId = cellId;
        this.ticketStatus = ticketStatus;
    }

    public UUID getId()                { return id; }
    public int getTicketNumber()       { return ticketNumber; }
    public LocalDateTime getEntryDate(){ return entryDate; }
    public String getLicensePlate()    { return licensePlate; }
    public UUID getVehicleTypeId()     { return vehicleTypeId; }
    public UUID getCellId()            { return cellId; }
    public UUID getTicketStatus()      { return ticketStatus; }

    public void setId(UUID id)                          { this.id = id; }
    public void setTicketNumber(int ticketNumber)       { this.ticketNumber = ticketNumber; }
    public void setEntryDate(LocalDateTime entryDate)   { this.entryDate = entryDate; }
    public void setLicensePlate(String licensePlate)    { this.licensePlate = licensePlate; }
    public void setVehicleTypeId(UUID vehicleTypeId)    { this.vehicleTypeId = vehicleTypeId; }
    public void setCellId(UUID cellId)                  { this.cellId = cellId; }
    public void setTicketStatus(UUID ticketStatus)      { this.ticketStatus = ticketStatus; }
}