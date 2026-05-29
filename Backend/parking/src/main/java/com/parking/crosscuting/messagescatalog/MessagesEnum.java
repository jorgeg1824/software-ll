package com.parking.crosscuting.messagescatalog;
 
import com.parking.crosscuting.helper.TextHelper;
 
public enum MessagesEnum {
 
    TICKET_REQUEST_NUMBER_INVALID(
        "Número de ticket inválido",
        "El número de ticket debe ser un valor entero positivo mayor a cero."
    ),
 
    TICKET_REQUEST_ENTRY_DATE_NULL(
        "Fecha de ingreso requerida",
        "La fecha y hora de ingreso del vehículo no puede ser nula."
    ),
 
    TICKET_REQUEST_ENTRY_DATE_FUTURE(
        "Fecha de ingreso inválida",
        "La fecha de ingreso no puede ser una fecha futura."
    ),
 
    TICKET_REQUEST_CELL_VEHICLE_NULL(
        "Celda-vehículo requerida",
        "El identificador de la celda-vehículo no puede ser nulo."
    ),
 
    TICKET_REQUEST_STATUS_NULL(
        "Estado del ticket requerido",
        "El identificador del estado del ticket no puede ser nulo."
    ),
 
    VEHICLE_USECASE_NULL_DATA(
        "Información del vehículo no válida",
        "La información requerida para registrar el vehículo no puede ser nula."
    ),

    VEHICLE_USECASE_ALREADY_INSIDE(
        "Vehículo ya registrado",
        "El vehículo seleccionado ya tiene un ticket de ingreso activo y se encuentra dentro del parqueadero."
    ),
 
    VEHICLE_USECASE_STATUS_NOT_FOUND(
        "Estado de ticket no encontrado",
        "No existe un estado de ticket registrado con el identificador proporcionado."
    ),
 
    VEHICLE_USECASE_ENTITY_MAPPING_ERROR(
        "Error al mapear el vehículo",
        "No fue posible transformar la información del vehículo a una entidad válida."
    ),
 
    VEHICLE_USECASE_REPOSITORY_NULL(
        "Repositorio de vehículos no disponible",
        "El repositorio requerido para registrar vehículos no está disponible."
    ),
 
    VEHICLE_USECASE_MAPPER_NULL(
        "Mapper de vehículos no disponible",
        "El mapper requerido para transformar la información del vehículo no está disponible."
    ),
 
    TICKET_DOMAIN_NUMBER_INVALID(
        "Invariante de dominio: número de ticket",
        "El número de ticket debe ser un valor positivo mayor a cero."
    ),
 
    TICKET_DOMAIN_ENTRY_DATE_NULL(
        "Invariante de dominio: fecha de ingreso",
        "La fecha de ingreso no puede ser nula en la entidad de dominio."
    ),
 
    TICKET_DOMAIN_ENTRY_DATE_FUTURE(
        "Invariante de dominio: fecha de ingreso futura",
        "La fecha de ingreso no puede ser posterior al momento actual."
    ),
 
    TICKET_DOMAIN_CELL_VEHICLE_NULL(
        "Invariante de dominio: celda-vehículo",
        "El identificador de la celda-vehículo no puede ser nulo en la entidad de dominio."
    ),
 
    TICKET_DOMAIN_STATUS_NULL(
        "Invariante de dominio: estado del ticket",
        "El identificador del estado del ticket no puede ser nulo en la entidad de dominio."
    ),
 
    GENERAL_UNEXPECTED_ERROR(
        "Error inesperado",
        "Ocurrió un error inesperado en el servidor. Por favor contacte al administrador."
    ),

    TICKET_REQUEST_CELL_ID_NULL(
    	    "Celda requerida",
    	    "El identificador de la celda no puede ser nulo."
    	),

    VEHICLE_USECASE_CELL_NOT_FOUND(
    	    "Celda no encontrada",
    	    "No existe una celda registrada con el identificador proporcionado."
    	),
    
    VEHICLE_USECASE_CELL_UNAVAILABLE(
    	    "Celda no disponible",
    	    "La celda seleccionada ya se encuentra ocupada."
    	),

    TICKET_DOMAIN_CELL_ID_NULL(
    	    "Invariante de dominio: celda",
    	    "El identificador de la celda no puede ser nulo en la entidad de dominio."
    	), 

    TICKET_REQUEST_LICENSE_PLATE_NULL(
        "Placa requerida",
        "La placa del vehículo no puede estar vacía."
    ),

    TICKET_REQUEST_LICENSE_PLATE_INVALID(
        "Placa inválida",
        "La placa solo puede contener letras, números y guiones."
    ),

    TICKET_REQUEST_VEHICLE_TYPE_NULL(
        "Tipo de vehículo requerido",
        "El identificador del tipo de vehículo no puede ser nulo."
    ),

    TICKET_DOMAIN_LICENSE_PLATE_NULL(
        "Invariante de dominio: placa",
        "La placa del vehículo no puede ser nula o vacía en la entidad de dominio."
    ),

    TICKET_DOMAIN_VEHICLE_TYPE_NULL(
        "Invariante de dominio: tipo de vehículo",
        "El tipo de vehículo no puede ser nulo en la entidad de dominio."
    );
 
    private String title;
    private String content;
 
    MessagesEnum(final String title, final String content) {
        setTitle(title);
        setContent(content);
    }
 
    public String getTitle() {
        return title;
    }
 
    private void setTitle(final String title) {
        this.title = TextHelper.getDefaultWithTrim(title);
    }
 
    public String getContent() {
        return content;
    }
 
    private void setContent(final String content) {
        this.content = TextHelper.getDefaultWithTrim(content);
    }
}