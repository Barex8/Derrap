create database derrap;
use derrap;

/*
DROP TABLE stock_proveedor;
DROP TABLE orden_pieza;
DROP TABLE cita;
DROP TABLE factura;
DROP TABLE metodo_pago;
DROP TABLE tipo_pago;
DROP TABLE proveedor;
DROP TABLE stock;
DROP TABLE orden_trabajo;
DROP TABLE estado_asignacion;
DROP TABLE estado_reparacion;
DROP TABLE vehiculo;
DROP TABLE servicio;
DROP TABLE cliente;
DROP TABLE usuario;
DROP TABLE rol;
*/
/*
SELECT* FROM stock_proveedor;
SELECT* FROM orden_pieza;
SELECT* FROM cita;
SELECT* FROM factura;
SELECT* FROM metodo_pago;
SELECT* FROM tipo_pago;
SELECT* FROM proveedor;
SELECT* FROM stock;
SELECT* FROM orden_trabajo;
SELECT* FROM estado_asignacion;
SELECT* FROM estado_reparacion;
SELECT* FROM vehiculo;
SELECT* FROM servicio;
SELECT* FROM cliente;
SELECT* FROM usuario;
SELECT* FROM rol;
*/

CREATE TABLE cliente (
dni_cliente VARCHAR(9) NOT NULL PRIMARY KEY,
nombre_cliente VARCHAR(50) NOT NULL,
primer_apellido_cliente VARCHAR(50) NOT NULL,
segundo_apellido_cliente VARCHAR(50) NOT NULL,
correo_electronico_cliente VARCHAR(50) NOT NULL,
telefono_cliente VARCHAR(9) NOT NULL,
ciudad_cliente VARCHAR(50) NOT NULL,
codigo_postal_cliente VARCHAR(5) NOT NULL
);

CREATE TABLE tipo_pago (
id_tipo_pago INT NOT NULL PRIMARY KEY,
nombre_tipo_pago VARCHAR(50) NOT NULL
);

CREATE TABLE metodo_pago (
id_metodo_pago INT NOT NULL PRIMARY KEY,
nombre_metodoPago VARCHAR(50) NOT NULL
);

CREATE TABLE estado_reparacion (
id_estado_reparacion INT NOT NULL PRIMARY KEY,
nombre_estado_reparacion VARCHAR(50) NOT NULL
);

CREATE TABLE estado_asignacion (
id_estado_asignacion INT NOT NULL PRIMARY KEY,
nombre_estado_asignacion VARCHAR(50) NOT NULL
);

CREATE TABLE servicio (
id_servicio INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
nombre_servicio VARCHAR(50) UNIQUE NOT NULL,
precio_servicio INT NOT NULL,
estado_alta_servicio VARCHAR(50) NOT NULL
);

CREATE TABLE proveedor (
cif_proveedor VARCHAR(9) NOT NULL PRIMARY KEY,
nombre_proveedor VARCHAR(50) NOT NULL,
correo_electronico_proveedor VARCHAR(50) NOT NULL,
direccion_proveedor VARCHAR(50) NOT NULL,
estado_proveedor VARCHAR(50) NOT NULL
);

CREATE TABLE stock (
oem_pieza_stock VARCHAR(5) NOT NULL PRIMARY KEY,
nombre_pieza_stock VARCHAR(50) UNIQUE NOT NULL,
marca_pieza_stock VARCHAR(50) NOT NULL,
cantidad_pieza_stock INT,
precio_pieza_stock INT NOT NULL,
estado_pieza_stock VARCHAR(50) NOT NULL
);

CREATE TABLE rol (
id_rol INT NOT NULL PRIMARY KEY,
nombre_rol VARCHAR(50) NOT NULL
);

CREATE TABLE usuario ( 
dni_usuario VARCHAR(9) NOT NULL PRIMARY KEY,
contraseña_usuario VARCHAR(50) NOT NULL,
nombre_usuario VARCHAR(50) UNIQUE NOT NULL,
correo_electronico_usuario VARCHAR(50) NOT NULL,
telefono_usuario VARCHAR(9) NOT NULL,
especialidad_usuario VARCHAR(50),
estado_alta_usuario VARCHAR(50) NOT NULL,
id_rol_usuario INT NOT NULL,
FOREIGN KEY (id_rol_usuario) REFERENCES rol (id_rol)
);

CREATE TABLE vehiculo (
matricula_vehiculo VARCHAR(7) NOT NULL PRIMARY KEY,
marca_vehiculo VARCHAR(50) NOT NULL,
modelo_vehiculo VARCHAR(50) NOT NULL,
año_vehiculo YEAR NOT NULL,
color_vehiculo VARCHAR(50) NOT NULL,
dni_cliente_vehiculo VARCHAR(9) NOT NULL,
FOREIGN KEY (dni_cliente_vehiculo) REFERENCES cliente (dni_cliente)
);

CREATE TABLE cita (
id_cita INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
fecha_cita DATE NOT NULL,
hora_cita TIME NOT NULL,
matricula_vehiculo_cita VARCHAR(7) NOT NULL,
FOREIGN KEY (matricula_vehiculo_cita) REFERENCES vehiculo (matricula_vehiculo)
);

CREATE TABLE orden_trabajo (
id_orden_trabajo INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
fecha_entrada_orden_trabajo DATE NOT NULL,
fecha_salida_orden_trabajo DATE,
descripcion_orden_trabajo VARCHAR(200),
sustitucion_pieza_orden_trabajo VARCHAR(2) NOT NULL,
id_servicio_orden_trabajo INT,
id_estado_asignacion_orden_trabajo INT NOT NULL,
id_estado_reparacion_orden_trabajo INT NOT NULL,
id_matricula_orden_trabajo VARCHAR(7) NOT NULL,
dni_usuario_orden_trabajo VARCHAR(9),
FOREIGN KEY (id_servicio_orden_trabajo) REFERENCES servicio (id_servicio),
FOREIGN KEY (id_estado_asignacion_orden_trabajo) REFERENCES estado_asignacion (id_estado_asignacion),
FOREIGN KEY (id_estado_reparacion_orden_trabajo) REFERENCES estado_reparacion (id_estado_reparacion),
FOREIGN KEY (id_matricula_orden_trabajo) REFERENCES vehiculo (matricula_vehiculo),
FOREIGN KEY (dni_usuario_orden_trabajo) REFERENCES usuario (dni_usuario)
);

CREATE TABLE factura (
id_factura INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
importe INT NOT NULL,
mensualidad INT,
id_tipo_pago_factura INT NOT NULL,
id_metodo_pago_factura INT NOT NULL,
id_orden_trabajo INT UNIQUE NOT NULL,
FOREIGN KEY (id_tipo_pago_factura) REFERENCES tipo_pago (id_tipo_pago),
FOREIGN KEY (id_metodo_pago_factura) REFERENCES metodo_pago (id_metodo_pago),
FOREIGN KEY (id_orden_trabajo) REFERENCES orden_trabajo (id_orden_trabajo)
);

CREATE TABLE orden_pieza (
id_orden_pieza INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
cantidad_orden_pieza INT NOT NULL,
id_orden_trabajo_orden_pieza INT NOT NULL,
oem_pieza_stock_orden_pieza VARCHAR(5) NOT NULL,
FOREIGN KEY (id_orden_trabajo_orden_pieza) REFERENCES orden_trabajo (id_orden_trabajo),
FOREIGN KEY (oem_pieza_stock_orden_pieza) REFERENCES stock (oem_pieza_stock)
);

CREATE TABLE stock_proveedor (
id_stock_proveedor INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
cantidad_stock_proveedor INT NOT NULL,
cif_proveedor_stock_proveedor VARCHAR(50) NOT NULL,
oem_pieza_stock_stock_proveedor VARCHAR(5) NOT NULL,
FOREIGN KEY (cif_proveedor_stock_proveedor) REFERENCES proveedor (cif_proveedor),
FOREIGN KEY (oem_pieza_stock_stock_proveedor) REFERENCES stock (oem_pieza_stock)
);

INSERT INTO tipo_pago VALUES
(1, 'PAGO ÚNICO'),
(2, 'PAGO FRACCIONADO'),
(3, 'PAGO MIXTO');
/* DELETE FROM tipo_pago; */

INSERT INTO metodo_pago VALUES
(1, 'EFECTIVO'),
(2, 'TARJETA');
/* DELETE FROM metodo_pago; */

INSERT INTO estado_reparacion VALUES
(1, 'SIN COMENZAR'),
(2, 'EN DIAGNÓSTICO'),
(3, 'EN REPARACIÓN'),
(4, 'FINALIZADA');
/* DELETE FROM estado_reparacion; */

INSERT INTO estado_asignacion VALUES
(1, 'PENDIENTE'),
(2, 'ASIGNADA');
/* DELETE FROM estado_asignacion; */

INSERT INTO servicio (nombre_servicio, precio_servicio, estado_alta_servicio) VALUES
('MECÁNICA', 200, 'ALTA'),
('DIAGNÓSTICO', 70, 'ALTA'),
('PRE-ITV', 50, 'ALTA'),
('FRENOS Y ABS', 200, 'ALTA'),
('ACEITE Y FILTROS', 80, 'ALTA'),
('NEUMÁTICOS', 50, 'ALTA'),
('REVISIÓN OFICIAL', 120, 'ALTA'),
('MATRÍCULAS', 50, 'ALTA'),
('CHAPA Y PINTURA', 200, 'ALTA'),
('EQUILIBRADO Y ALINEACIÓN', 120, 'ALTA'),
('CLIMATIZACIÓN / AIRE ACONDICIONADO', 120, 'ALTA'),
('ELECTRICIDAD / ELECTRÓNICA', 250, 'ALTA');
/* DELETE FROM servicio; */

INSERT INTO rol VALUES
(1, 'ADMINISTRADOR'),
(2, 'MECÁNICO');
/* DELETE FROM rol; */

INSERT INTO usuario VALUES
/*hay que añadir especialidades a los 5 mecánicos, pero no sé aún qué poner*/
('90217112A', 'Admin1', 'ADMIN', 'admin@gmail.com', '609090909', null, 'ALTA', 1), 
('47604707C', 'Contraseña1', 'MARCOS1', 'marcos1@gmail.com', '601010101', 'MECÁNICA', 'ALTA', 2),
('11494234F', 'Contraseña2', 'JUAN1', 'juan1@gmail.com', '602020202', 'MECÁNICA', 'ALTA', 2),
('19367406A', 'Contraseña3', 'PAULA1', 'paula1@gmail.com', '603030303', 'ELECTRÓNICA', 'ALTA', 2),
('82959165M', 'Contraseña4', 'CARMEN1', 'carmen1@gmail.com', '604040404', 'CHAPA Y PINTURA', 'ALTA', 2),
('31858579Z', 'Contraseña5', 'ALBERTO1', 'alberto1@gmail.com', '605050505', 'NEUMÁTICA', 'ALTA', 2);
/* DELETE FROM usuario; */

INSERT INTO cliente VALUES
('03140345V', 'MIGUEL', 'PARIENTE', 'LÓPEZ', 'miguelpariente@gmail.com', '611111111', 'MÁLAGA', '29006'),
('74444976W', 'MANUEL', 'FERNÁNDEZ', 'GARCÍA', 'manuelfernandez@gmail.com', '612121212', 'MÁLAGA', '29006'),
('90493940A', 'CLARA', 'BALSAS', 'GÓMEZ', 'clarabalsas@gmail.com', '613131313', 'GRANADA', '18004'),
('30163944L', 'SEBAS', 'RUÍZ', 'ROMERO', 'sebasruiz@gmail.com', '614141414', 'MÁLAGA', '29003');
/* DELETE FROM cliente; */

INSERT INTO vehiculo VALUES
('1234GHI','SEAT','ALTEA', 2010, 'BLANCO', '03140345V'),
('1234JNL','HYUNDAI','I10', 2015, 'VERDE', '74444976W'),
('1234LLS','AUDI','Q5', 2019, 'NEGRO', '90493940A'),
('1234KAB','HYUNDAI','I30', 2018, 'NEGRO', '90493940A'),
('1234DLZ','OPEL','ZAFIRA', 2003, 'GRIS', '30163944L');
/* DELETE FROM vehiculo; */

INSERT INTO proveedor VALUES
('A82563289', 'RECAMBIOS MALAGA', 'recambiosmalaga@gmail.com', 'direccion1', 'ALTA'),
('A89233428', 'PIEZAS ANTEQUERAS', 'piezasantequera@gmail.com', 'direccion2', 'ALTA'),
('A84395136', 'AUTO-PINTURAS', 'auto-pinturas@gmail.com', 'direccion3', 'ALTA'),
('A17766650', 'ELEC-AUTO', 'elec-auto@gmail.com', 'direccion4', 'ALTA');
/* DELETE FROM proveedor; */

INSERT INTO stock VALUES
('84857', 'TORNILLO 1', 'ATE', 200, 1, 'ALTA'),
('47771', 'TORNILLO 2', 'ATE', 200, 2, 'ALTA'),
('86450', 'TORNILLO 3', 'BOSCH', 50, 4, 'ALTA'),
('72754', 'BOMBILLA 1', 'PHILIPS', 20, 10, 'ALTA'),
('15976', 'EMBRAGUE 1', 'BOSCH', 1, 800, 'ALTA'),
('70841', 'NEUMÁTICO 1', 'MICHELIN', 3, 100, 'ALTA'),
('66900', 'NEUMÁTICO 2', 'MICHELIN', 0, 100, 'ALTA'),
('45090', 'BUJÍA 1', 'ATE', 1, 15, 'ALTA'),
('00207', 'CORREA DE DISTRIBUCIÓN 1', 'BOSCH', 0, 1000, 'ALTA'),
('67110', 'EJE DE RUEDA 1', 'MICHELIN', 0, 120, 'ALTA'),
('05912', 'FILTRO DE AIRE 1', 'HELLA', 5, 100, 'ALTA'),
('28059', 'FILTRO DE ACEITE 1', 'HELLA', 10, 35, 'ALTA'),
('39758', 'FILTRO DE ACEITE 2', 'HELLA', 0, 70, 'ALTA'),
('47143', 'FILTRO DE ACEITE 3', 'HELLA', 0, 130, 'BAJA'),
('39646', 'LITROS ACEITE 1', 'HELLA', 300, 4, 'ALTA'),
('85373', 'LITROS ACEITE 2', 'HELLA', 50, 10, 'ALTA'),
('74410', 'LITROS ACEITE 3', 'HELLA', 0, 16, 'BAJA'),
('03732', 'AMORTIGUADOR 1', 'ATE', 0, 400, 'ALTA'),
('12297', 'MOTOR 1', 'ATE', 0, 1500, 'ALTA'),
('48158', 'MOTOR 2', 'ATE', 0, 1600, 'ALTA'),
('25644', 'MOTOR 3', 'ATE', 0, 1650, 'BAJA'),
('18579', 'MOTOR 4', 'ATE', 0, 2000, 'ALTA'),
('44222', 'RODAMIENTOS 1', 'BOSCH', 3, 200, 'ALTA'),
('30357', 'BATERIA 1', 'PHILIPS', 4, 300, 'ALTA'),
('47616', 'BATERIA 2', 'PHILIPS', 4, 300, 'ALTA'),
('34251', 'FUSIBLE 1', 'PHILIPS', 6, 50, 'ALTA'),
('86863', 'FUSIBLE 2', 'PHILIPS', 7, 65, 'ALTA'),
('98625', 'RADIADOR 1', 'PHILIPS', 2, 250, 'ALTA'),
('86400', 'PARAGOLPES 1', 'HELLA', 0, 650, 'ALTA'),
('59824', 'PARAGOLPES 2', 'HELLA', 0, 700, 'ALTA');
/* DELETE FROM stock; */

INSERT INTO cita (fecha_cita, hora_cita, matricula_vehiculo_cita) VALUES
("2024-10-20", "10:00:00", '1234GHI'),
("2024-10-22", "16:00:00", '1234JNL'),
("2024-10-23", "10:00:00", '1234LLS'),
("2024-10-23", "10:00:00", '1234KAB'),
("2024-10-25", "16:00:00", '1234DLZ');
/* DELETE FROM cita; */

INSERT INTO orden_trabajo VALUES
(1, "2024-10-20", "2024-10-20", 'HACER UN REPASO PRE-ITV', 'NO', 3, 2, 4, '1234GHI','47604707C'),
(2, "2024-10-23", "2024-10-25", 'RUIDO EN DOS RUEDAS', 'NO', 10, 2, 4, '1234JNL','31858579Z'),
(3, "2024-10-23", "2024-10-23", 'DIAGNÓSTICO BREVE', 'NO', 2, 2, 4, '1234LLS','11494234F'),
(4, "2024-10-23", "2024-10-23", 'DIAGNÓSTICO BREVE', 'NO', 2, 2, 4, '1234KAB','11494234F'),
(5, "2024-10-25", "2024-10-25", 'CAMBIO DE ACEITE, EL CLIENTE LO APORTA', 'NO', 5, 2, 4, '1234DLZ','82959165M');
/* DELETE FROM orden_trabajo; */

INSERT INTO factura VALUES
(1, 80, null, 1, 1, 1),
(2, 180, null, 1, 1, 2),
(3, 100, null, 1, 2, 3),
(4, 100, null, 1, 2, 4),
(5, 110, null, 1, 1, 5);
/* DELETE FROM factura; */