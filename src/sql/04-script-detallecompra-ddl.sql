-- Creación de la tabla detalle_compra
CREATE TABLE IF NOT EXISTS detalle_compra (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nombreUsuario VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(25) NOT NULL,
    direccion VARCHAR(100)

);