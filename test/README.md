# API de Franquicias

API para gestionar franquicias, sucursales y productos con stock.  una franquicia tiene sucursales, y cada sucursal tiene productos con cantidad disponible.

La hice con Spring Boot 4, WebFlux + R2DBC y MySQL. Organicé el código por capas (dominio, casos de uso, infraestructura y controllers REST) para separar reglas de negocio de la persistencia y la API.

## Arranque con Docker
docker compose up --build

- App: http://localhost:8080
- Swagger: http://localhost:8080/swagger-ui/index.html
- Health: http://localhost:8080/actuator/health

Al iniciar ya vienen datos de ejemplo: franquicia Franquicia Norte, dos sucursales y algunos productos.

Usuario y Contraseña: admin / admin123

## Autenticación

Obtienes un token:

`POST /api/autenticacion/iniciar-sesion`

{
  "username": "admin",
  "password": "admin123"
}

El resto de endpoints lo piden. En Swagger: Authorize → Bearer token.