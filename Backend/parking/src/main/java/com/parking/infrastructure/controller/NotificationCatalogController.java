package com.parking.infrastructure.controller;

import com.parking.infrastructure.persistence.repository.sql.jpa.CatalogoNotificacionJPARepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/notifications/catalog")
@Tag(name = "Catálogo de Notificaciones",
     description = "Plantillas de mensajes para notificaciones del sistema")
public class NotificationCatalogController {

    private final CatalogoNotificacionJPARepository repository;

    public NotificationCatalogController(
            final CatalogoNotificacionJPARepository repository) {
        this.repository = repository;
    }

    @Operation(
        summary = "Listar plantillas activas",
        description = "Retorna todas las plantillas de notificación activas en español e inglés."
    )
    @GetMapping
    public ResponseEntity<List<Map<String, Object>>> findAll() {
        List<Map<String, Object>> result = repository.findAll()
                .stream()
                .filter(n -> Boolean.TRUE.equals(n.isActivo()))
                .map(n -> Map.<String, Object>of(
                        "id",       n.getId(),
                        "codigo",   n.getCodigo(),
                        "canal",    n.getCanal(),
                        "asuntoEs", n.getAsuntoEs() != null ? n.getAsuntoEs() : "",
                        "asuntoEn", n.getAsuntoEn() != null ? n.getAsuntoEn() : "",
                        "cuerpoEs", n.getCuerpoEs(),
                        "cuerpoEn", n.getCuerpoEn()
                ))
                .toList();

        return ResponseEntity.ok(result);
    }
}