package com.parking.infrastructure.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Value("${server.port:8080}")
    private String serverPort;

    @Bean
    public OpenAPI parkingOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Sistema de Parqueaderos API")
                        .description("""
                                API REST para la gestión de parqueaderos.
                                
                                Implementada con Clean Architecture (Ports & Adapters).
                                
                                **Transacción disponible:**
                                - Registro de ingreso de vehículos
                                """)
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Equipo de Desarrollo")
                                .email("parking@universidad.edu.co"))
                        .license(new License()
                                .name("Uso académico")
                                .url("https://github.com/TU_USUARIO/parking-system")))
                .servers(List.of(
                        new Server()
                                .url("http://localhost:" + serverPort)
                                .description("Servidor de desarrollo local"),
                        new Server()
                                .url("https://parking-backend-161379807540.us-central1.run.app")
                                .description("Servidor de producción (GCP Cloud Run)")
                ));
    }
}