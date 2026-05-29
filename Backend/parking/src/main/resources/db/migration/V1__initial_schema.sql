CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE tipo_vehiculo (
    id_tipo_vehiculo UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    nombre_tipo_vehiculo VARCHAR(100) NOT NULL,
    descripcion VARCHAR(255),
    tarifa_aplicada NUMERIC(10,2) NOT NULL,
    es_activo BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE vehiculo (
    id_vehiculo UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    placa VARCHAR(10) NOT NULL UNIQUE,
    id_tipo_vehiculo UUID NOT NULL,

    CONSTRAINT fk_vehiculo_tipo
    FOREIGN KEY (id_tipo_vehiculo)
    REFERENCES tipo_vehiculo(id_tipo_vehiculo)
);