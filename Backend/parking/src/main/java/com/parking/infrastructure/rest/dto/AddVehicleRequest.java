package com.parking.infrastructure.rest.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;
import java.util.UUID;

public class AddVehicleRequest {

    @Positive(message = "TICKET_REQUEST_NUMBER_INVALID")
    private int ticketNumber;

    @NotNull(message = "TICKET_REQUEST_ENTRY_DATE_NULL")
    @PastOrPresent(message = "TICKET_REQUEST_ENTRY_DATE_FUTURE")
    private LocalDateTime entryDate;

    @NotBlank(message = "TICKET_REQUEST_LICENSE_PLATE_NULL")
    @Pattern(regexp = "^[A-Za-z0-9-]+$",
             message = "TICKET_REQUEST_LICENSE_PLATE_INVALID")
    private String licensePlate;          

    @NotNull(message = "TICKET_REQUEST_VEHICLE_TYPE_NULL")
    private UUID vehicleTypeId;           

    @NotNull(message = "TICKET_REQUEST_CELL_ID_NULL")
    private UUID cellId;

    @NotNull(message = "TICKET_REQUEST_STATUS_NULL")
    private UUID ticketStatus;
    
    private String cellName;  

    public AddVehicleRequest() {}

    public int getTicketNumber()        { return ticketNumber; }
    public LocalDateTime getEntryDate() { return entryDate; }
    public String getLicensePlate()     { return licensePlate; }
    public UUID getVehicleTypeId()      { return vehicleTypeId; }
    public UUID getCellId()             { return cellId; }
    public UUID getTicketStatus()       { return ticketStatus; }
    public String getCellName() { return cellName; }

    public void setTicketNumber(int ticketNumber)           { this.ticketNumber = ticketNumber; }
    public void setEntryDate(LocalDateTime entryDate)       { this.entryDate = entryDate; }
    public void setLicensePlate(String licensePlate)        { this.licensePlate = licensePlate; }
    public void setVehicleTypeId(UUID vehicleTypeId)        { this.vehicleTypeId = vehicleTypeId; }
    public void setCellId(UUID cellId)                      { this.cellId = cellId; }
    public void setTicketStatus(UUID ticketStatus)          { this.ticketStatus = ticketStatus; }
    public void setCellName(String cellName) { this.cellName = cellName; }
}