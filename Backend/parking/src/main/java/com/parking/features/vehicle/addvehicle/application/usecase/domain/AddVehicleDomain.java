package com.parking.features.vehicle.addvehicle.application.usecase.domain;

import com.parking.crosscuting.messagescatalog.MessagesEnum;
import java.time.LocalDateTime;
import java.util.UUID;

public class AddVehicleDomain extends Domain {

    private int ticketNumber;
    private LocalDateTime entryDate;
    private String licensePlate;  
    private UUID vehicleTypeId;     
    private UUID cellId;
    private UUID ticketStatus;

    public AddVehicleDomain(final UUID id, final int ticketNumber,
                             final LocalDateTime entryDate, final String licensePlate,
                             final UUID vehicleTypeId, final UUID cellId,
                             final UUID ticketStatus) {
        super(id);
        setTicketNumber(ticketNumber);
        setEntryDate(entryDate);
        setLicensePlate(licensePlate);
        setVehicleTypeId(vehicleTypeId);
        setCellId(cellId);
        setTicketStatus(ticketStatus);
    }

    public int getTicketNumber()       { return ticketNumber; }
    public LocalDateTime getEntryDate(){ return entryDate; }
    public String getLicensePlate()    { return licensePlate; }
    public UUID getVehicleTypeId()     { return vehicleTypeId; }
    public UUID getCellId()            { return cellId; }
    public UUID getTicketStatus()      { return ticketStatus; }

    public void setTicketNumber(final int ticketNumber) {
        if (ticketNumber <= 0)
            throw new IllegalArgumentException(MessagesEnum.TICKET_DOMAIN_NUMBER_INVALID.name());
        this.ticketNumber = ticketNumber;
    }

    public void setEntryDate(final LocalDateTime entryDate) {
        if (entryDate == null)
            throw new IllegalArgumentException(MessagesEnum.TICKET_DOMAIN_ENTRY_DATE_NULL.name());
        if (entryDate.isAfter(LocalDateTime.now()))
            throw new IllegalArgumentException(MessagesEnum.TICKET_DOMAIN_ENTRY_DATE_FUTURE.name());
        this.entryDate = entryDate;
    }

    public void setLicensePlate(final String licensePlate) {
        if (licensePlate == null || licensePlate.isBlank())
            throw new IllegalArgumentException(MessagesEnum.TICKET_DOMAIN_LICENSE_PLATE_NULL.name());
        this.licensePlate = licensePlate.toUpperCase().trim();
    }

    public void setVehicleTypeId(final UUID vehicleTypeId) {
        if (vehicleTypeId == null)
            throw new IllegalArgumentException(MessagesEnum.TICKET_DOMAIN_VEHICLE_TYPE_NULL.name());
        this.vehicleTypeId = vehicleTypeId;
    }

    public void setCellId(final UUID cellId) {
        if (cellId == null)
            throw new IllegalArgumentException(MessagesEnum.TICKET_DOMAIN_CELL_ID_NULL.name());
        this.cellId = cellId;
    }

    public void setTicketStatus(final UUID ticketStatus) {
        if (ticketStatus == null)
            throw new IllegalArgumentException(MessagesEnum.TICKET_DOMAIN_STATUS_NULL.name());
        this.ticketStatus = ticketStatus;
    }
}