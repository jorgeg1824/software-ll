package com.parking.infrastructure.persistence.repository.sql.jpa.entity;

import java.util.UUID;

import com.parking.crosscuting.helper.BooleanHelper;
import com.parking.crosscuting.helper.TextHelper;
import com.parking.crosscuting.helper.UUIDHelper;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Administrador")
public final class ManagerJPAEntity {
	
	@Id
	@Column(name = "id_administrador")
    private UUID id;
	
	@Column(name = "numero_documento")
    private String documentNumber;
	
	@Column(name = "nombre_administrador")
    private String name;
	
	@Column(name = "primer_apellido")
    private String firstSurname;
	
	@Column(name = "segundo_apellido")
    private String secondSurname;
	
	@Column(name = "correo")
    private String email;
	
	@Column(name = "telefono")
    private String phoneNumber;
	
	@Column(name = "confirmacion_correo")
    private boolean emailConfirmed;
	
	@Column(name = "confirmacion_telefono")
    private boolean phoneConfirmed;
	
	@Column(name = "es_activo")
    private boolean active;

    public ManagerJPAEntity() {
        setId(UUIDHelper.getUUIDHelper().getDefault());
        setDocumentNumber(TextHelper.getDefault());
        setName(TextHelper.getDefault());
        setFirstSurname(TextHelper.getDefault());
        setSecondSurname(TextHelper.getDefault());
        setEmail(TextHelper.getDefault());
        setPhoneNumber(TextHelper.getDefault());
        setEmailConfirmed(false);
        setPhoneConfirmed(false);
        setActive(false);
    }

    public ManagerJPAEntity(final UUID id, final String documentNumber, final String name, final String firstSurname,
                         final String secondSurname, final String email, final String phoneNumber,
                         final boolean emailConfirmed, final boolean phoneConfirmed, final boolean active) {
        setId(id);
        setDocumentNumber(documentNumber);
        setName(name);
        setFirstSurname(firstSurname);
        setSecondSurname(secondSurname);
        setEmail(email);
        setPhoneNumber(phoneNumber);
        setEmailConfirmed(emailConfirmed);
        setPhoneConfirmed(phoneConfirmed);
        setActive(active);
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = UUIDHelper.getUUIDHelper().getDefault(id);
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(final String documentNumber) {
        this.documentNumber = TextHelper.getDefaultWithTrim(documentNumber);
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = TextHelper.getDefaultWithTrim(name);
    }

    public String getFirstSurname() {
        return firstSurname;
    }

    public void setFirstSurname(final String firstSurname) {
        this.firstSurname = TextHelper.getDefaultWithTrim(firstSurname);
    }

    public String getSecondSurname() {
        return secondSurname;
    }

    public void setSecondSurname(final String secondSurname) {
        this.secondSurname = TextHelper.getDefaultWithTrim(secondSurname);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = TextHelper.getDefaultWithTrim(email);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(final String phoneNumber) {
        this.phoneNumber = TextHelper.getDefaultWithTrim(phoneNumber);
    }

    public boolean isEmailConfirmed() {
        return emailConfirmed;
    }

    public void setEmailConfirmed(final boolean emailConfirmed) {
        this.emailConfirmed = BooleanHelper.getDefault(emailConfirmed);
    }

    public boolean isPhoneConfirmed() {
        return phoneConfirmed;
    }

    public void setPhoneConfirmed(final boolean phoneConfirmed) {
        this.phoneConfirmed = BooleanHelper.getDefault(phoneConfirmed);
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(final boolean active) {
        this.active = BooleanHelper.getDefault(active);
    }
}
