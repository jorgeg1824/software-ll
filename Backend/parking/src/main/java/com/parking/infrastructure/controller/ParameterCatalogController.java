package com.parking.infrastructure.controller;

import com.parking.infrastructure.persistence.repository.adapter.sql.jpa.ParameterCatalogQueryService;
import com.parking.infrastructure.rest.dto.ParameterCatalogResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/parameters")
@Tag(name = "Catálogo de parámetros",
     description = "Parámetros de configuración del sistema de parqueaderos")
public class ParameterCatalogController {

    private final ParameterCatalogQueryService service;

    public ParameterCatalogController(
            final ParameterCatalogQueryService service) {
        this.service = service;
    }

    @Operation(
        summary = "Listar parámetros del sistema",
        description = """
            Retorna todos los parámetros de configuración activos.
            Los resultados se cachean por 5 minutos para optimizar el rendimiento.
            
            Parámetros disponibles:
            - TARIFA_HORA_CARRO / MOTO / CAMION: tarifas por hora en COP
            - TOLERANCIA_MINUTOS_GRACIA: minutos sin cobro al ingresar
            - TIEMPO_MAXIMO_ESTADIA_HORAS: máximo de horas permitidas
            - MONEDA, HORARIO_APERTURA, HORARIO_CIERRE
            - IMPUESTO_IVA_PORCENTAJE, CAPACIDAD_MAXIMA_PARQUEADERO
            """
    )
    @ApiResponse(responseCode = "200", description = "Lista de parámetros activos")
    @GetMapping
    public ResponseEntity<List<ParameterCatalogResponse>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @Operation(
        summary = "Buscar parámetro por clave",
        description = "Retorna el valor de un parámetro específico. Ej: TARIFA_HORA_CARRO"
    )
    @ApiResponse(responseCode = "200", description = "Parámetro encontrado")
    @ApiResponse(responseCode = "404", description = "Parámetro no encontrado o inactivo")
    @GetMapping("/{clave}")
    public ResponseEntity<ParameterCatalogResponse> findByClave(
            @PathVariable final String clave) {

        return service.findAll()
                .stream()
                .filter(p -> p.clave().equalsIgnoreCase(clave))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}