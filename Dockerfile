# ---------- Etapa 1: Compilación ----------
FROM eclipse-temurin:21-jdk-alpine AS build
WORKDIR /app

# Copiar el wrapper y el pom
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

# Forzar el permiso de ejecución directo en Linux
RUN chmod +x mvnw

# Descarga de dependencias en caché de Docker
RUN ./mvnw dependency:go-offline -B

# Copia de código fuente y empaquetado
COPY src ./src
RUN ./mvnw clean package -DskipTests -B

# ---------- Etapa 2: Imagen de Ejecución ----------
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]