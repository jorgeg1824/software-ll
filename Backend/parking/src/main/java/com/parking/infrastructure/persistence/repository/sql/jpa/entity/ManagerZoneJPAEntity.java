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
import jakarta.persistence.Table;

@Entity
@Table(name = "AdministradorZona")
public final class ManagerZoneJPAEntity {
	
	@Id
	@Column(name = "id_admin_zona")
    private UUID id;
	
	@Column(name = "fecha_administrada")
    private LocalDateTime administrationDate;
	
	@ManyToOne
	@JoinColumn(name = "id_administrador")
    private ManagerJPAEntity manager;
	
	@ManyToOne
	@JoinColumn(name = "id_zona")
    private ZoneJPAEntity zone;

    public ManagerZoneJPAEntity() {
        setId(UUIDHelper.getUUIDHelper().getDefault());
        setAdministrationDate(null);
        setManager(new ManagerJPAEntity());
        setZone(new ZoneJPAEntity());
    }

    public ManagerZoneJPAEntity(final UUID id, final LocalDateTime administrationDate, final ManagerJPAEntity manager, final ZoneJPAEntity zone) {
        setId(id);
        setAdministrationDate(administrationDate);
        setManager(manager);
        setZone(zone);
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = UUIDHelper.getUUIDHelper().getDefault(id);
    }

    public LocalDateTime getAdministrationDate() {
        return administrationDate;
    }

    public void setAdministrationDate(final LocalDateTime administrationDate) {
        this.administrationDate = administrationDate;
    }

    public ManagerJPAEntity getManager() {
        return manager;
    }

    public void setManager(final ManagerJPAEntity manager) {
        this.manager = ObjectHelper.getDefault(manager, new ManagerJPAEntity());
    }

    public ZoneJPAEntity getZone() {
        return zone;
    }

    public void setZone(final ZoneJPAEntity zone) {
        this.zone = ObjectHelper.getDefault(zone, new ZoneJPAEntity());
    }
}
