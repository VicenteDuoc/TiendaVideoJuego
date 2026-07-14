# TiendaVideoJuego - Sistema de Microservicios

Sistema de tienda de videojuegos basado en arquitectura de microservicios, desarrollado con Spring Boot 3.2, MySQL 8.0 y Docker. Cada servicio es independiente, tiene su propia base de datos y se comunica con los demas a traves de HTTP.

Proyecto academico - DuocUC.

---

## Arquitectura

El sistema esta compuesto por 10 microservicios, 1 API Gateway y 1 base de datos MySQL, orquestados con Docker Compose.

| Servicio | Puerto | Base de datos | Descripcion |
|---|---:|---|---|
| Notificaciones | 8080 | notificaciones_db | Gestion de notificaciones a usuarios |
| Producto | 8081 | producto_db | Catalogo de videojuegos |
| Pago | 8082 | pago_db | Procesamiento de pagos |
| Categoria | 8083 | categoria_db | Categorias de productos |
| Calificar | 8084 | calificar_db | Calificaciones y resenas |
| Entrega | 8085 | entrega_db | Gestion de envios |
| Carrito | 8086 | carrito_db | Carrito de compras |
| Pedido | 8087 | pedido_db | Pedidos y cancelaciones |
| Registro | 8088 | registro_db | Registro y gestion de usuarios |
| Autenticacion | 8089 | autenticacion_db | Login con JWT |
| Gateway | 8090 | - | Entrada principal para Postman y clientes |

Autenticacion llama a Registro mediante WebClient para validar credenciales durante el login.

---

## Tecnologias

- Java 17
- Spring Boot 3.2.0
- Spring Web
- Spring Data JPA
- Spring WebFlux
- Spring Validation
- Hibernate / JPA
- Lombok
- Flyway
- MySQL 8.0
- JJWT 0.12.5
- Maven multi-modulo
- Docker y Docker Compose

---

## Mejoras agregadas al proyecto

Para la entrega se agregaron y configuraron las siguientes mejoras:

- API Gateway en el puerto 8090 como punto unico de entrada para los microservicios.
- Rutas por Gateway usando el prefijo `/api`, por ejemplo `/api/producto`, `/api/auth/login` y `/api/pedido`.
- Microservicio de Autenticacion con login, validacion de token y logout usando JWT.
- Comunicacion entre Autenticacion y Registro mediante WebClient para validar usuarios.
- Docker Compose para levantar MySQL, los 10 microservicios y el Gateway con un solo comando.
- Bases de datos separadas por microservicio, inicializadas desde MySQL y migraciones Flyway.
- Swagger/OpenAPI disponible en los microservicios y tambien desde el Gateway.
- Pruebas unitarias con JUnit 5 y Mockito para validar logica de servicios sin depender de MySQL.
- Ejemplos de uso en Postman para probar GET y POST desde el Gateway.

El flujo recomendado para probar el sistema es:

```text
Postman -> Gateway http://localhost:8090/api/... -> Microservicio correspondiente -> MySQL
```

---

## Como levantar el proyecto

### Requisitos previos

- Docker Desktop instalado y corriendo.
- Git instalado.
- Puertos libres: 3307, 8080-8090.

### Levantar todos los servicios

Desde la raiz del proyecto:

```bash
docker compose up --build
```

O en segundo plano:

```bash
docker compose up -d --build
```

Verificar estado:

```bash
docker compose ps
```

El API Gateway queda disponible en:

```text
http://localhost:8090
```

---

## Pruebas con Postman

Para probar el sistema completo se recomienda usar siempre el Gateway:

```text
http://localhost:8090
```

En requests con body, usar:

```text
Content-Type: application/json
```

### Login

```text
POST http://localhost:8090/api/auth/login
```

Body:

```json
{
  "email": "admin@tienda.cl",
  "password": "admin123"
}
```

Usuarios iniciales:

```text
admin@tienda.cl / admin123
vicente@duoc.cl / vicente123
test@tienda.cl / test123
```

### Validar token

```text
POST http://localhost:8090/api/auth/validar
```

Body:

```json
{
  "token": "PEGAR_TOKEN_DEL_LOGIN"
}
```

### Productos

```text
GET  http://localhost:8090/api/producto
POST http://localhost:8090/api/producto
```

Body para crear:

```json
{
  "nombre": "Minecraft",
  "precio": 19990
}
```

### Categorias

```text
GET  http://localhost:8090/api/categoria
POST http://localhost:8090/api/categoria
```

Body para crear:

```json
{
  "nombre": "Aventura",
  "descripcion": "Juegos de aventura"
}
```

### Carrito

```text
GET  http://localhost:8090/api/carrito/usuario/1
POST http://localhost:8090/api/carrito
```

Body para agregar item:

```json
{
  "idUsuario": 1,
  "idProducto": 1,
  "cantidad": 1
}
```

### Pedido

```text
GET  http://localhost:8090/api/pedido
POST http://localhost:8090/api/pedido
```

Body para crear:

```json
{
  "idUsuario": 1,
  "total": 32000
}
```

### Otros endpoints principales

```text
GET  http://localhost:8090/api/pago
GET  http://localhost:8090/api/entrega
GET  http://localhost:8090/api/calificacion
GET  http://localhost:8090/api/notificacion
GET  http://localhost:8090/api/registro
```

El gateway usa el prefijo `/api`. Por ejemplo, `/api/producto` llega al microservicio Producto como `/producto`.

---

## Swagger / OpenAPI

Swagger del Gateway:

```text
http://localhost:8090/swagger-ui.html
```

Swagger directo por microservicio:

```text
http://localhost:8080/swagger-ui.html
http://localhost:8081/swagger-ui.html
http://localhost:8082/swagger-ui.html
http://localhost:8083/swagger-ui.html
http://localhost:8084/swagger-ui.html
http://localhost:8085/swagger-ui.html
http://localhost:8086/swagger-ui.html
http://localhost:8087/swagger-ui.html
http://localhost:8088/swagger-ui.html
http://localhost:8089/swagger-ui.html
```

---

## Pruebas unitarias

Ejecutar:

```bash
mvn test
```

Las pruebas unitarias usan JUnit 5 y Mockito para validar reglas de negocio y dependencias simuladas sin requerir MySQL.
