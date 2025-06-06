-- Creación de la tabla compra
CREATE TABLE IF NOT EXISTS compra (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    fechaDeCompra VARCHAR(100) NOT NULL,
    total VARCHAR(100) NOT NULL,
    password VARCHAR(25) NOT NULL,
    direccion VARCHAR(100)

);