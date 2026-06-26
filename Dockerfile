# ---------- Etapa 1: Compilación ----------
FROM eclipse-temurin:21-jdk-alpine AS build
WORKDIR /app

# Descarga de dependencias en caché de Docker
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline -B

# Copia de código fuente y empaquetado sin ejecutar pruebas (CI las correrá)
COPY src ./src
RUN ./mvnw clean package -DskipTests -B

# ---------- Etapa 2: Imagen de Ejecución ----------
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Cumplimiento de restricción: Usuario sin privilegios Root
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

# Copiar el compilado ejecutable desde la etapa anterior
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]