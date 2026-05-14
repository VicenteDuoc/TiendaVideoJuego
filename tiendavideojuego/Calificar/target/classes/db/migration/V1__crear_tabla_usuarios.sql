CREATE TABLE calificacion (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_juego BIGINT,
    puntuacion INT,
    comentario VARCHAR(255)
);