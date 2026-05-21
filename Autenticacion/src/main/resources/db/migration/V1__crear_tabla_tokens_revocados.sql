CREATE TABLE tokens_revocados (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    token VARCHAR(500) NOT NULL UNIQUE,
    id_usuario BIGINT NOT NULL,
    email VARCHAR(150) NOT NULL,
    fecha_revocacion DATETIME NOT NULL
);