package com.parking.infrastructure.persistence.repository.sql.jpa.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import com.parking.crosscuting.helper.ObjectHelper;
import com.parking.crosscuting.helper.UUIDHelper;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Ticket")
public final class TicketJPAEntity {
	
	@Id
	@Column(name = "id_ticket")
    private UUID id;
	
	@Column(name = "numero_ticket")
    private int ticketNumber;
	
	@Column(name = "fecha_entrada")
    private LocalDateTime entryDate;
	
	@OneToOne
	@JoinColumn(name = "id_celda_vehiculo")
    private CellVehicleJPAEntity cellVehicle;
	
	@ManyToOne
	@JoinColumn(name = "id_estado_ticket")
    private TicketStatusJPAEntity ticketStatus;

    public TicketJPAEntity() {
        setId(UUIDHelper.getUUIDHelper().getDefault());
        setTicketNumber(0);
        setEntryDate(null);
        setCellVehicle(new CellVehicleJPAEntity());
        setTicketStatus(new TicketStatusJPAEntity());
    }

    public TicketJPAEntity(final UUID id, final int ticketNumber, final LocalDateTime entryDate,
                        final CellVehicleJPAEntity cellVehicle, final TicketStatusJPAEntity ticketStatus) {
        setId(id);
        setTicketNumber(ticketNumber);
        setEntryDate(entryDate);
        setCellVehicle(cellVehicle);
        setTicketStatus(ticketStatus);
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = UUIDHelper.getUUIDHelper().getDefault(id);
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(final int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public LocalDateTime getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(final LocalDateTime entryDate) {
        this.entryDate = entryDate;
    }

    public CellVehicleJPAEntity getCellVehicle() {
        return cellVehicle;
    }

    public void setCellVehicle(final CellVehicleJPAEntity cellVehicle) {
        this.cellVehicle = ObjectHelper.getDefault(cellVehicle, new CellVehicleJPAEntity());
    }

    public TicketStatusJPAEntity getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(final TicketStatusJPAEntity ticketStatus) {
        this.ticketStatus = ObjectHelper.getDefault(ticketStatus, new TicketStatusJPAEntity());
    }
}
