# Buhos-App

Buhos-App es una API REST modular diseñada para la gestión, control y reserva de asientos en salas, auditorios o 
eventos dentro del entorno universitario. El sistema permite administrar de forma eficiente la disponibilidad de 
espacios físicos, la creación de salas dinámicas y el procesamiento seguro de reservas simultáneas.

El backend está construido bajo una arquitectura limpia **N-Capas** (Controladores, Servicios, Repositorios) 
garantizando un desacoplamiento óptimo, facilidad de testing y alta escalabilidad en la nube.

## 🛠️ Stack Tecnológico

- **Core Runtime:** Java 21 & Spring Boot 3.x
- **Persistencia de Datos:** Spring Data JPA & Hibernate
- **Motor de Base de Datos:** PostgreSQL 16 (Producción/Contenedores)
- **Base de Datos en Memoria:** H2 Database (Exclusivo para entornos de Pruebas/Testing)
- **Gestor de Dependencias:** Maven
- **Contenedorización y Orquestación:** Docker & Docker Compose
- **Integración y Despliegue Continuo (CI/CD):** GitHub Actions

---

## 🧱 Arquitectura y Estructura del Proyecto

El diseño del código sigue el patrón estándar de Spring Boot para el aislamiento de responsabilidades:

```text
src/main/java/lat/buhoseats/api/
│
├── config/
├── controllers/
├── domain/
├      ├── dtos/
├      ├── entities/
├── exceptions/
├── repositories/
└── services/
├      ├── Impl/
```

## 🚀 Ejecución y Despliegue Local

### 1. Requisitos Previos

Tener instalado en tu sistema:
- **Docker Desktop** (v20.10+ recomendado)
- **Docker Compose**
- **Git**

### 2. Configuración del Entorno (`.env`)

El proyecto utiliza variables de entorno. Duplica el archivo de ejemplo y configura tus valores locales:

```bash
cp .env.example .env

DATABASE_NAME=buhos_db
DATABASE_USERNAME=buhos_user
DATABASE_PASSWORD=securePassword
```
## 🚀 Gestión del Entorno con Docker Compose

Este proyecto utiliza Docker Compose para orquestar la API y la base de datos PostgreSQL de manera automatizada utilizando las configuraciones definidas en tu archivo `.env`.

### 1. Levantar la Infraestructura

Para construir las imágenes e iniciar todos los servicios (Base de Datos + API) en segundo plano (*detached mode*), ejecuta el siguiente comando en la raíz del proyecto:

```bash
docker compose up --build -d
```

### Control de Contenedores
Construye las imágenes desde cero e inicia todos los servicios en segundo plano.
```bash
docker compose up --build -d
```

Detiene y elimina los contenedores activos, pero mantiene intactos los datos de la base de datos.
```bash
docker compose down
```

Detiene todo y borra por completo los volúmenes, eliminando toda la información de la base de datos.
```bash
docker compose down -v
```

--

### Monitoreo y Diagnóstico
Muestra el estado actual de los contenedores y los puertos en los que están escuchando.
```bash
docker compose ps
```

Muestra las salidas y logs de todos los contenedores al mismo tiempo en tiempo real.
```bash
docker compose logs -f
```

Muestra únicamente los logs de la API de Spring Boot.
```bash
docker compose logs -f app
```

Muestra únicamente los logs del motor de base de datos PostgreSQL en tiempo real.
```bash
docker compose logs -f db
```

---

### Mantenimiento
Muestra el consumo de CPU, memoria y red de cada contenedor en vivo.
```bash
docker stats
```

Reinicia de forma rápida únicamente el contenedor de la API sin afectar a la base de datos.
```bash
docker compose restart app
```
