CREATE TABLE calificacion(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_juego BIGINT NOT NULL,
    puntuacion INT NOT NULL,
    comentario VARCHAR(1000)
);