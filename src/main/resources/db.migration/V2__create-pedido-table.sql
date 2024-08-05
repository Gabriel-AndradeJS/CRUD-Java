CREATE TABLE pedido(
    id INT DEFAULT PRIMARY KEY,
    pedidos VARCHAR(50) NOT NULL,
    preco DOUBLE NOT NULL,
    qtd INT NOT NULL,
    mesa_id INT,
    FOREIGN KEY (mesa_id) REFERENCES mesa(id) ON DELETE CASCADE
);