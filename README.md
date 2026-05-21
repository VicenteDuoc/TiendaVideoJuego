\# 🎮 TiendaVideoJuego — Sistema de Microservicios



Sistema de tienda de videojuegos basado en arquitectura de microservicios, desarrollado con Spring Boot 3.2, MySQL 8.0 y Docker. Cada servicio es independiente, tiene su propia base de datos y se comunica con los demás a través de HTTP.



Proyecto académico — DuocUC.



\---



\## 🧱 Arquitectura



El sistema está compuesto por \*\*10 microservicios\*\* + \*\*1 base de datos MySQL\*\* orquestados con Docker Compose.



| # | Microservicios | Puerto | Base de datos     | Descripción                          |

|---|---             |---     |---                |---                                   |

| 1 | Notificaciones | 8080   | notificaciones\_db | Gestión de notificaciones a usuarios |

| 2 | Producto       | 8081   | producto\_db       | Catálogo de videojuegos              |

| 3 | Pago           | 8082   | pago\_db           | Procesamiento de pagos               |

| 4 | Categoria      | 8083   | categoria\_db      | Categorías de productos              |

| 5 | Calificar      | 8084   | calificar\_db      | Calificaciones y reseñas             |

| 6 | Entrega        | 8085   | entrega\_db        | Gestión de envíos                    |

| 7 | Carrito        | 8086   | carrito\_db        | Carrito de compras                   |

| 8 | Pedido         | 8087   | pedido\_db         | Pedidos y cancelaciones              |

| 9 | Registro       | 8088   | registro\_db       | Registro y gestión de usuarios       |

| 10| Autenticacion  | 8089   | autenticacion\_db  | Login con JWT                        |



Comunicación entre microservicios: \*\*Autenticacion\*\* llama a \*\*Registro\*\* vía WebClient (WebFlux) para validar credenciales en el login.

Esto es por lo que se dictó la clase del pasado Miércoles 20 de mayo.



\---



\## 🛠️ Tecnologías utilizadas



\- \*\*Java 17\*\* (Eclipse Temurin)

\- \*\*Spring Boot 3.2.0\*\*

&#x20; - Spring Web

&#x20; - Spring Data JPA

&#x20; - Spring WebFlux (WebClient para comunicación entre microservicios)

&#x20; - Spring Validation

\- \*\*Hibernate / JPA\*\* para persistencia ORM

\- \*\*Lombok\*\* para reducir código boilerplate

\- \*\*Flyway\*\* para migraciones de base de datos versionadas

\- \*\*MySQL 8.0\*\* como motor de base de datos

\- \*\*JJWT 0.12.5\*\* para tokens JWT con firma HMAC-SHA512

\- \*\*Maven multi-módulo\*\* para gestión de dependencias

\- \*\*Docker + Docker Compose\*\* para contenerización y orquestación



\---



\## 🚀 Cómo levantar el proyecto



\### Requisitos previos



\- Docker Desktop instalado y corriendo

\- Git instalado

\- Puertos libres: 3306, 8080–8089



\### Pasos



```bash

