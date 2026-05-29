package com.parking.infrastructure.persistence.repository.sql.jpa.entity;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;

import com.parking.crosscuting.helper.ObjectHelper;
import com.parking.crosscuting.helper.UUIDHelper;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "SalidaVehiculo")
public final class VehicleExitJPAEntity {
	
	@Id
	@Column(name = "id_salida_vehiculo")
    private UUID id;
	
	@Column(name = "fecha_salida")
    private LocalDateTime exitDate;
	
	@Column(name = "tiempo_estadia")
    private Duration stayDuration;
	
	@Column(name = "valor_pagar")
    private BigDecimal totalAmount;
	
	@OneToOne
	@JoinColumn(name = "id_ticket")
    private TicketJPAEntity ticket;

    public VehicleExitJPAEntity() {
        setId(UUIDHelper.getUUIDHelper().getDefault());
        setExitDate(null);
        setStayDuration(null);
        setTotalAmount(BigDecimal.ZERO);
        setTicket(new TicketJPAEntity());
    }

    public VehicleExitJPAEntity(final UUID id, final LocalDateTime exitDate, final Duration stayDuration,
                             final BigDecimal totalAmount, final TicketJPAEntity ticket) {
        setId(id);
        setExitDate(exitDate);
        setStayDuration(stayDuration);
        setTotalAmount(totalAmount);
        setTicket(ticket);
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = UUIDHelper.getUUIDHelper().getDefault(id);
    }

    public LocalDateTime getExitDate() {
        return exitDate;
    }

    public void setExitDate(final LocalDateTime exitDate) {
        this.exitDate = exitDate;
    }

    public Duration getStayDuration() {
        return stayDuration;
    }

    public void setStayDuration(final Duration stayDuration) {
        this.stayDuration = stayDuration;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(final BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public TicketJPAEntity getTicket() {
        return ticket;
    }

    public void setTicket(final TicketJPAEntity ticket) {
        this.ticket = ObjectHelper.getDefault(ticket, new TicketJPAEntity());
    }
}
