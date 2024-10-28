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

/*CREATE TABLE mensualidad (
id_mensualidad INT NOT NULL PRIMARY KEY,
cantidad_mensualidad INT NOT NULL
); */

CREATE TABLE estado_reparacion (
id_estado_reparacion INT NOT NULL PRIMARY KEY,
nombre_estado_reparacion VARCHAR(50) NOT NULL
);

CREATE TABLE estado_asignacion (
id_estado_asignacion INT NOT NULL PRIMARY KEY,
nombre_estado_asignacion VARCHAR(50) NOT NULL
);

CREATE TABLE servicio (
id_servicio INT NOT NULL PRIMARY KEY,
nombre_servicio VARCHAR(50) NOT NULL,
precio_servicio INT NOT NULL,
estado_servicio VARCHAR(50) NOT NULL
);

CREATE TABLE proveedor (
cif_proveedor INT NOT NULL PRIMARY KEY,
nombre_proveedor VARCHAR(50) NOT NULL,
correo_electronico_proveedor VARCHAR(50) NOT NULL,
direccion_proveedor VARCHAR(50) NOT NULL,
estado_proveedor VARCHAR(50) NOT NULL
);

CREATE TABLE stock (
oem_pieza_stock INT NOT NULL PRIMARY KEY,
nombre_pieza_stock VARCHAR(50) NOT NULL,
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
nombre_usuario VARCHAR(50) NOT NULL,
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
año_vehiculo YEAR NOT NULL,
color_vehiculo VARCHAR(50) NOT NULL,
dni_cliente_vehiculo VARCHAR(9) NOT NULL,
FOREIGN KEY (dni_cliente_vehiculo) REFERENCES cliente (dni_cliente)
);

CREATE TABLE cita (
id_cita INT NOT NULL PRIMARY KEY,
fecha_cita DATE NOT NULL,
hora_cita TIME NOT NULL,
matricula_vehiculo_cita VARCHAR(7) NOT NULL,
FOREIGN KEY (matricula_vehiculo_cita) REFERENCES vehiculo (matricula_vehiculo)
);

CREATE TABLE orden_trabajo (
id_orden_trabajo INT NOT NULL PRIMARY KEY,
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
id_factura INT NOT NULL PRIMARY KEY,
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
id_orden_pieza INT NOT NULL PRIMARY KEY,
cantidad_orden_pieza INT NOT NULL,
id_orden_trabajo_orden_pieza INT NOT NULL,
oem_pieza_stock_orden_pieza INT NOT NULL,
FOREIGN KEY (id_orden_trabajo_orden_pieza) REFERENCES orden_trabajo (id_orden_trabajo),
FOREIGN KEY (oem_pieza_stock_orden_pieza) REFERENCES stock (oem_pieza_stock)
);

CREATE TABLE stock_proveedor (
id_stock_proveedor INT NOT NULL PRIMARY KEY,
cantidad_stock_proveedor INT NOT NULL,
cif_proveedor_stock_proveedor INT NOT NULL,
oem_pieza_stock_stock_proveedor INT NOT NULL,
FOREIGN KEY (cif_proveedor_stock_proveedor) REFERENCES proveedor (cif_proveedor),
FOREIGN KEY (oem_pieza_stock_stock_proveedor) REFERENCES stock (oem_pieza_stock)
);