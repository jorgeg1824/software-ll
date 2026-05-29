# ── Etapa 1: Compilar ────────────────────────────────────────────────────────
FROM maven:3.9-eclipse-temurin-26 AS builder

WORKDIR /app

# Descarga dependencias primero (aprovecha caché de Docker)
COPY pom.xml .
RUN mvn dependency:go-offline -q

# Compila el proyecto
COPY src ./src
RUN mvn package -DskipTests -q

# ── Etapa 2: Imagen de ejecución ─────────────────────────────────────────────
# Si eclipse-temurin:26-jre-alpine no está disponible aún, usa eclipse-temurin:26-jre
FROM eclipse-temurin:26-jre

WORKDIR /app

# Usuario sin privilegios root (buena práctica de seguridad)
RUN groupadd -r parking && useradd -r -g parking parking
USER parking

COPY --from=builder /app/target/parking-*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "-Djava.security.egd=file:/dev/./urandom", "app.jar"]