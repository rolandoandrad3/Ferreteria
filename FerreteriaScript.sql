create database ferreteria;
use ferreteria;

-- Tabla Para la categorias de la Ferreteria 
CREATE TABLE categorias (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre_categoria VARCHAR(255)
);
INSERT INTO categorias (nombre_categoria) VALUES ('Herramientas');
INSERT INTO categorias (nombre_categoria) VALUES ('Materiales de Construcción');
INSERT INTO categorias (nombre_categoria) VALUES ('Pinturas y Acabados');
INSERT INTO categorias (nombre_categoria) VALUES ('Jardinería');
INSERT INTO categorias (nombre_categoria) VALUES ('Seguridad y Protección');

-- Tabla Persona para los datos de los clientes
CREATE TABLE persona (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    apellido VARCHAR(255),
    direccion VARCHAR(255),
    telefono VARCHAR(20),
    correo VARCHAR(255),
    fecha_nacimiento DATE,
    genero VARCHAR(10),
    documento VARCHAR(50),
    tipo_persona VARCHAR(50),
    estado VARCHAR(50),
    fecha_creacion DATE,
    fecha_modificacion DATE,
    usuario_creacion VARCHAR(50),
    usuario_modificacion VARCHAR(50),
    rol VARCHAR(50),
    estado_cuenta VARCHAR(50)
);
INSERT INTO persona (nombre, apellido, direccion, telefono, correo, fecha_nacimiento, genero, documento, tipo_persona, estado, fecha_creacion, fecha_modificacion, usuario_creacion, usuario_modificacion, rol, estado_cuenta) VALUES
('Juan', 'Perez', '123 Calle Falsa', '123456789', 'juan.perez@example.com', '1980-01-01', 'Masculino', '12345678', 'Cliente', 'Activo', '2024-01-01', '2024-01-01', 'admin', 'admin', 'Usuario', 'Activa'),
('Ana', 'Gomez', '456 Calle Real', '987654321', 'ana.gomez@example.com', '1985-02-02', 'Femenino', '87654321', 'Proveedor', 'Activo', '2024-01-01', '2024-01-01', 'admin', 'admin', 'Usuario', 'Activa'),
('Luis', 'Martinez', '789 Avenida Siempre Viva', '123123123', 'luis.martinez@example.com', '1990-03-03', 'Masculino', '11223344', 'Cliente', 'Activo', '2024-01-01', '2024-01-01', 'admin', 'admin', 'Usuario', 'Activa'),
('Maria', 'Rodriguez', '321 Avenida Libertad', '321321321', 'maria.rodriguez@example.com', '1987-04-04', 'Femenino', '44332211', 'Proveedor', 'Activo', '2024-01-01', '2024-01-01', 'admin', 'admin', 'Usuario', 'Activa'),
('Carlos', 'Lopez', '654 Calle Nueva', '456456456', 'carlos.lopez@example.com', '1975-05-05', 'Masculino', '55667788', 'Cliente', 'Activo', '2024-01-01', '2024-01-01', 'admin', 'admin', 'Usuario', 'Activa');


-- Tabla para Estados de Clientes, Empleados y Proveedores
CREATE TABLE cliente (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    fecha_ingreso DATE,
    estado VARCHAR(255),
    persona_id BIGINT,
    FOREIGN KEY (persona_id) REFERENCES persona(id)
);

INSERT INTO cliente (fecha_ingreso, estado, persona_id) VALUES
('2024-01-15', 'Activo', 1),
('2023-06-22', 'Inactivo', 2),
('2024-03-10', 'Activo', 3),
('2022-12-01', 'Inactivo', 4),
('2024-05-05', 'Activo', 5);

-- Tabla para definir los tipos de transaccion 
CREATE TABLE tipo_transaccion (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    tipo_transaccion VARCHAR(255)
);
INSERT INTO tipo_transaccion (tipo_transaccion) VALUES 
('Compra'),
('Venta'),
('Devolución'),
('Transferencia'),
('Ajuste');

-- Tabla para definir los tipos de pago que se recibiran
CREATE TABLE tipos_pago (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    tipo_pago VARCHAR(255)
);

INSERT INTO tipos_pago (tipo_pago) VALUES 
('Efectivo'),
('Tarjeta de Crédito'),
('Tarjeta de Débito'),
('Transferencia Bancaria'),
('Cheque');

CREATE TABLE pago (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    monto DOUBLE,
    fecha_pago DATE,
    factura_id BIGINT,
    tipo_pago_id BIGINT,
    FOREIGN KEY (tipo_pago_id) REFERENCES tipos_pago(id)
);

INSERT INTO pago (monto, fecha_pago, factura_id, tipo_pago_id)
VALUES
(50.0, '2024-06-01', 1, 1),
(75.0, '2024-06-02', 2, 2),
(100.0, '2024-06-03', 3, 1),
(120.0, '2024-06-04', 4, 2),
(80.0, '2024-06-05', 5, 1);

select * from pago;


-- Tabla para proveedores
-- Creación de la tabla proveedor
CREATE TABLE proveedor (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    estado VARCHAR(255),
    fecha_ingreso DATETIME,
    fecha_creacion DATETIME,
    persona_id BIGINT,
    FOREIGN KEY (persona_id) REFERENCES persona(id)
);

-- Inserción de datos en la tabla proveedor
INSERT INTO proveedor (estado, fecha_ingreso, fecha_creacion, persona_id) VALUES
('Activo', '2024-06-01 12:00:00', '2024-06-01 08:00:00', 1),
('Inactivo', '2023-05-15 14:30:00', '2023-05-15 09:00:00', 2),
('Activo', '2024-04-20 16:45:00', '2024-04-20 10:00:00', 3),
('Inactivo', '2022-12-01 11:00:00', '2022-12-01 07:00:00', 4),
('Activo', '2024-07-05 09:15:00', '2024-07-05 06:00:00', 5);

-- Creación de la tabla empleado
CREATE TABLE empleado (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    apellido VARCHAR(255),
    direccion VARCHAR(255),
    telefono VARCHAR(20),
    correo VARCHAR(255),
    fecha_nacimiento DATE,
    genero VARCHAR(10),
    dui VARCHAR(20),
    nit VARCHAR(20),
    nrc VARCHAR(20),
    tipo_persona VARCHAR(50),
    estado VARCHAR(50),
    salario DOUBLE,
    fecha_contratacion DATE,
    cargo VARCHAR(100),
    jefe VARCHAR(255),
    persona_id BIGINT,
    FOREIGN KEY (persona_id) REFERENCES persona(id)
);

-- Inserción de datos en la tabla empleado
INSERT INTO empleado (nombre, apellido, direccion, telefono, correo, fecha_nacimiento, genero, dui, nit, nrc, tipo_persona, estado, salario, fecha_contratacion, cargo, jefe, persona_id) VALUES
('Juan', 'Pérez', 'Calle Principal 123', '78901234', 'juan.perez@example.com', '1990-05-15', 'Masculino', '12345678-9', '1234-567890-123-4', '987654-3', 'Empleado', 'Activo', 1500.00, '2020-01-15', 'Vendedor', 'Pedro García', 1),
('María', 'López', 'Avenida Central 456', '61234567', 'maria.lopez@example.com', '1985-08-20', 'Femenino', '98765432-1', '4321-098765-321-1', '765432-1', 'Empleado', 'Activo', 1800.00, '2018-03-10', 'Gerente de Ventas', 'Roberto Martínez', 2),
('Carlos', 'González', 'Boulevard Norte 789', '74561230', 'carlos.gonzalez@example.com', '1995-12-10', 'Masculino', '87654321-0', '5678-123456-789-0', '654321-0', 'Empleado', 'Activo', 1300.00, '2021-06-05', 'Cajero', 'Laura Ramírez', 3);

-- Productos
CREATE TABLE productos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre_producto VARCHAR(255),
    descripcion TEXT,
    cantidad INTEGER,
    precio DOUBLE,
    fecha DATE,
    categoria_id BIGINT,
    FOREIGN KEY (categoria_id) REFERENCES categorias(id)
);

INSERT INTO productos (nombre_producto, descripcion, cantidad, precio, fecha, categoria_id) VALUES
('Martillo', 'Martillo de acero forjado, ideal para trabajos de construcción.', 10, 25.99, '2024-06-01', 1),
('Destornillador', 'Destornillador de punta plana y mango ergonómico.', 20, 12.50, '2024-06-02', 1),
('Sierra eléctrica', 'Sierra eléctrica compacta con motor de alta potencia.', 5, 149.99, '2024-06-03', 2),
('Pintura blanca', 'Pintura acrílica blanca para interiores.', 15, 35.75, '2024-06-04', 3),
('Llave inglesa', 'Llave inglesa ajustable de alta resistencia.', 8, 18.99, '2024-06-05', 1);

-- Factura

CREATE TABLE factura (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    fecha_factura DATE,
    total DOUBLE,
    cliente_id BIGINT,
    empleado_id BIGINT,
    categoria_id BIGINT,
    pago_id BIGINT,
    tipo_pago_id BIGINT,
    FOREIGN KEY (cliente_id) REFERENCES cliente(id),
    FOREIGN KEY (empleado_id) REFERENCES empleado(id),
    FOREIGN KEY (categoria_id) REFERENCES categorias(id),
    FOREIGN KEY (pago_id) REFERENCES pago(id),
    FOREIGN KEY (tipo_pago_id) REFERENCES tipos_pago(id)
);
INSERT INTO factura (fecha_factura, total, cliente_id, empleado_id, categoria_id, pago_id, tipo_pago_id)
VALUES
('2024-06-01', 150.0, 1, 1, 1, 1, 1),
('2024-06-02', 200.0, 2, 2, 2, 2, 2),
('2024-06-03', 300.0, 3, 3, 1, 3, 1),
('2024-06-04', 250.0, 4, 1, 2, 4, 2),
('2024-06-05', 180.0, 5, 2, 1, 5, 1);


-- Detalle Factura

CREATE TABLE detalle_factura (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    cantidad INTEGER,
    precio_unitario DOUBLE,
    subtotal DOUBLE,
    producto_id BIGINT,
    factura_id BIGINT,
    FOREIGN KEY (producto_id) REFERENCES productos(id),
    FOREIGN KEY (factura_id) REFERENCES factura(id)
);
select * from factura;

INSERT INTO detalle_factura (cantidad, precio_unitario, subtotal, productos_id, factura_id)
VALUES
(2, 50.0, 100.0, 1, 1),
(3, 40.0, 120.0, 2, 2),
(1, 300.0, 300.0, 3, 3),
(4, 25.0, 100.0, 4, 4),
(5, 36.0, 180.0, 5, 5);


CREATE TABLE transaccion (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    fecha DATE,
    monto DOUBLE,
    cliente_id BIGINT,
    factura_id BIGINT,
    pago_id BIGINT,
    producto_id BIGINT,
    categoria_id BIGINT,
    proveedor_id BIGINT,
    empleado_id BIGINT,
    persona_id BIGINT,
    tipos_pago_id BIGINT,
    tipo_transaccion_id BIGINT,
    FOREIGN KEY (cliente_id) REFERENCES cliente(id),
    FOREIGN KEY (factura_id) REFERENCES factura(id),
    FOREIGN KEY (pago_id) REFERENCES pago(id),
    FOREIGN KEY (producto_id) REFERENCES productos(id),
    FOREIGN KEY (categoria_id) REFERENCES categorias(id),
    FOREIGN KEY (proveedor_id) REFERENCES proveedor(id),
    FOREIGN KEY (empleado_id) REFERENCES empleado(id),
    FOREIGN KEY (persona_id) REFERENCES persona(id),
    FOREIGN KEY (tipos_pago_id) REFERENCES tipos_pago(id),
    FOREIGN KEY (tipo_transaccion_id) REFERENCES tipo_transaccion(id)
);

INSERT INTO transaccion (fecha, monto, cliente_id, factura_id, pago_id, producto_id, categoria_id, proveedor_id, empleado_id, persona_id, tipos_pago_id, tipo_transaccion_id)
VALUES
('2024-06-01', 100.0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
('2024-06-02', 150.0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2),
('2024-06-03', 200.0, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3),
('2024-06-04', 120.0, 4, 4, 4, 4, 4, 1, 2, 4, 4, 4),
('2024-06-05', 180.0, 5, 5, 5, 5, 5, 2, 3, 5, 5, 5);

CREATE TABLE orden (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    fecha VARCHAR(255),
    total DECIMAL(10, 2),
    cliente_id BIGINT,
    empleado_id BIGINT,
    producto_id BIGINT,
    categoria_id BIGINT,
    pago_id BIGINT,
    tipo_pago_id BIGINT,
    FOREIGN KEY (cliente_id) REFERENCES cliente(id),
    FOREIGN KEY (empleado_id) REFERENCES empleado(id),
    FOREIGN KEY (producto_id) REFERENCES productos(id),
    FOREIGN KEY (categoria_id) REFERENCES categorias(id),
    FOREIGN KEY (pago_id) REFERENCES pago(id),
    FOREIGN KEY (tipo_pago_id) REFERENCES tipos_pago(id));
    
INSERT INTO orden (fecha, total, cliente_id, empleado_id, producto_id, categoria_id, pago_id, tipo_pago_id) VALUES
('2023-01-01', 100.50, 1, 1, 1, 1, 1, 1),
('2023-02-15', 250.00, 2, 2, 2, 2, 2, 2),
('2023-03-10', 75.00, 3, 3, 3, 3, 3, 3),
('2023-04-25', 50.75, 4, 1, 4, 4, 4, 4),
('2023-05-05', 150.20, 5, 2, 5, 5, 5, 5);

Select * from orden

Select * from detalle_factura





