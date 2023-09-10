INSERT INTO Cargos (nombre_Cargo) VALUES ('Asesor'), ('Administrador'), ('Soporte');

-- Insertar datos de usuarios y asociarlos a roles
INSERT INTO usuarios (id_cargo, nombre_usuario, edad, fecha_ingreso_compañia)
VALUES
    (1, 'Juan Pérez', 30, '2023-09-09'),
    (2, 'Ana Rodríguez', 28, '2023-09-08'),
    (3, 'Carlos Sánchez', 35, '2023-09-07');

-- Asociar roles a los usuarios
-- Asesor
UPDATE usuarios SET id_cargo = 1 WHERE nombre_usuario = 'Juan Pérez';
-- Administrador
UPDATE usuarios SET id_cargo = 2 WHERE nombre_usuario = 'Ana Rodríguez';
-- Soporte
UPDATE usuarios SET id_cargo = 3 WHERE nombre_usuario = 'Carlos Sánchez';
----------------------------------------------------------------------------

--Mercancia, Usuarios
INSERT INTO mercancias (id_usuario, nombre_producto, cantidad, fecha_ingreso)
VALUES
    (1, 'Producto 1', 100, '2023-09-09'),
    (2, 'Producto 2', 50, '2023-09-08'),
    (3, 'Producto 3', 75, '2023-09-07');

UPDATE mercancias SET id_usuario = 1 WHERE nombre_producto = 'Producto 1';
UPDATE mercancias SET id_usuario = 2 WHERE nombre_producto = 'Producto 2';
UPDATE mercancias SET id_usuario = 3 WHERE nombre_producto = 'Producto 3';
