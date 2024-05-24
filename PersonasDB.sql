CREATE DATABASE IF NOT EXISTS PersonasDB;
USE PersonasDB;

CREATE TABLE IF NOT EXISTS personas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    edad INT NOT NULL,
    direccion VARCHAR(100),
    email VARCHAR(50),
    fechaNacimiento DATE
);

-- Insertar datos en la tabla personas
INSERT INTO personas (nombre, apellido, edad, direccion, email, fechaNacimiento) 
VALUES 
    ('Juan', 'Pérez', 25, 'Calle Falsa 123', 'juan.perez@example.com', '1990-05-15'),
    ('María', 'López', 30, 'Avenida Siempre Viva 456', 'maria.lopez@example.com', '1988-09-28'),
    ('Carlos', 'González', 28, 'Calle Luna 789', 'carlos.gonzalez@example.com', '1995-02-10'),
    ('Ana', 'Martínez', 22, 'Avenida Sol 101', 'ana.martinez@example.com', '2000-11-20'),
    ('Luis', 'Rodríguez', 35, 'Calle Estrella 202', 'luis.rodriguez@example.com', '1985-07-03'),
    ('Lucía', 'Hernández', 27, 'Avenida Mar 303', 'lucia.hernandez@example.com', '1992-04-18');

COMMIT;

SELECT * FROM personas;


