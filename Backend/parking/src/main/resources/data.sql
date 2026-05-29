INSERT INTO "TipoVehiculo" (
    id_tipo_vehiculo,
    nombre_tipo_vehiculo,
    descripcion,
    tarifa_aplicada,
    es_activo
)
VALUES
(
    'b2c3d4e5-0002-0002-0002-000000000001',
    'Automóvil',
    'Vehículo particular de cuatro ruedas',
    5000,
    true
),
(
    'b2c3d4e5-0002-0002-0002-000000000002',
    'Motocicleta',
    'Vehículo tipo motocicleta',
    3000,
    true
),
(
    'b2c3d4e5-0002-0002-0002-000000000003',
    'Camión',
    'Vehículo de carga pesada',
    10000,
    true
)
ON CONFLICT (id_tipo_vehiculo) DO NOTHING;

INSERT INTO "TipoCelda" (
    id_tipo_celda,
    nombre_tipo_celda,
    descripcion,
    es_activo
)
VALUES
(
    '7e2d3a5c-1b2a-4c3e-9a6f-123456789abc',
    'Carro',
    'Celda para automóvil',
    true
),
(
    '8f2e1b4d-3c2a-4e1f-8d9b-abcdef123456',
    'Moto',
    'Celda para motocicleta',
    true
),
(
    '9a4f2c6b-7d3e-4a9b-8c7f-fedcba987654',
    'Bicicleta',
    'Celda para bicicleta',
    true
),
(
    '223f3831-2898-4c70-85a2-7b76b97fcdf1',
    'Avion',
    'Celda para avión',
    true
)
ON CONFLICT (id_tipo_celda) DO NOTHING;

INSERT INTO "Vehiculo" (
    id_vehiculo,
    placa,
    id_tipo_vehiculo
)
VALUES
(
    'c3d4e5f6-0003-0003-0003-000000000001',
    'ABC123',
    'b2c3d4e5-0002-0002-0002-000000000001'
)
ON CONFLICT (id_vehiculo) DO NOTHING;

INSERT INTO "Zona" (
    id_zona,
    nombre_zona,
    descripcion,
    es_activo
)
VALUES
(
    '8f1a6b5c-9d7e-4c2a-8e1f-abcdef123456',
    'Zona A',
    'Zona principal del parqueadero',
    true
),
(
    '9b2a7c5e-8d6f-4c3b-9e2d-fedcba654321',
    'Zona B',
    'Zona lateral del parqueadero',
    true
),
(
    '7a1b5c3d-4e2f-4a9d-9f8b-123456abcdef',
    'Zona C',
    'Zona trasera del parqueadero',
    true
)
ON CONFLICT (id_zona) DO NOTHING;

INSERT INTO "Celda" (
    id_celda,
    nombre_celda,
    es_activo,
    id_zona,
    id_tipo_celda
)
VALUES
(
    '75b43d9b-3cf3-481a-9672-a2a250764b01',
    'A-1',
    true,
    '8f1a6b5c-9d7e-4c2a-8e1f-abcdef123456',
    '7e2d3a5c-1b2a-4c3e-9a6f-123456789abc'
),
(
    '7a3e2328-3813-489c-b8e6-770cd8d27236',
    'A-2',
    true,
    '8f1a6b5c-9d7e-4c2a-8e1f-abcdef123456',
    '7e2d3a5c-1b2a-4c3e-9a6f-123456789abc'
),
(
    '237d4a42-e7f5-4fc9-add5-e64de581650e',
    'A-3',
    true,
    '8f1a6b5c-9d7e-4c2a-8e1f-abcdef123456',
    '7e2d3a5c-1b2a-4c3e-9a6f-123456789abc'
),
(
    '29691fc8-c53a-46c1-8aec-25587f7aade5',
    'A-4',
    true,
    '8f1a6b5c-9d7e-4c2a-8e1f-abcdef123456',
    '7e2d3a5c-1b2a-4c3e-9a6f-123456789abc'
),
(
    '5acf2145-92e9-49d6-bcd3-e7631142dbcf',
    'A-5',
    true,
    '8f1a6b5c-9d7e-4c2a-8e1f-abcdef123456',
    '7e2d3a5c-1b2a-4c3e-9a6f-123456789abc'
),
(
    '981b9231-3b35-48cd-a097-af8ae01a6a5b',
    'A-6',
    true,
    '8f1a6b5c-9d7e-4c2a-8e1f-abcdef123456',
    '8f2e1b4d-3c2a-4e1f-8d9b-abcdef123456'
),
(
    'fd8e47c5-c325-4ef8-9ab4-7434afd3a45b',
    'A-7',
    true,
    '8f1a6b5c-9d7e-4c2a-8e1f-abcdef123456',
    '8f2e1b4d-3c2a-4e1f-8d9b-abcdef123456'
),
(
    '98d86004-d5b8-4916-9954-4364437bcf78',
    'B-1',
    true,
    '9b2a7c5e-8d6f-4c3b-9e2d-fedcba654321',
    '8f2e1b4d-3c2a-4e1f-8d9b-abcdef123456'
),
(
    '525e1c1d-192d-4f29-b09b-d5759ac65d10',
    'B-2',
    true,
    '9b2a7c5e-8d6f-4c3b-9e2d-fedcba654321',
    '8f2e1b4d-3c2a-4e1f-8d9b-abcdef123456'
),
(
    '1a97a818-1537-4fdb-a1a9-aa99b17f65ff',
    'B-3',
    true,
    '9b2a7c5e-8d6f-4c3b-9e2d-fedcba654321',
    '8f2e1b4d-3c2a-4e1f-8d9b-abcdef123456'
)
ON CONFLICT (id_celda) DO NOTHING;
