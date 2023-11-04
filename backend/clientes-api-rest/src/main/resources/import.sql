INSERT INTO roles (nombre) VALUES ('ROLE_USER');
INSERT INTO roles (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO usuarios (username, password, enabled, nombre, apellido, email) VALUES ('user', '$2a$10$ErgB6ZGOen0Eo4jW9x0yO.08u/IIheGny4C8ZmYn8//NwF8ZVBibu', 1, 'User', 'User', 'user@gmail.com');
INSERT INTO usuarios (username, password, enabled, nombre, apellido, email) VALUES ('admin', '$2a$10$ErgB6ZGOen0Eo4jW9x0yO.08u/IIheGny4C8ZmYn8//NwF8ZVBibu', 1, 'Oscar', 'Santamaría', 'osantamaria@gmail.com');

INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (1, 1);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (2, 1);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (2, 2);

INSERT INTO productos (nombre, precio, create_at) VALUES('Panasonic Pantalla LCD', 259990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Sony Camara digital DSC-W320B', 123490, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Apple iPod shuffle', 1499990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Sony Notebook Z110', 37990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Hewlett Packard Multifuncional F2280', 69990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Bianchi Bicicleta Aro 26', 69990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Mica Comoda 5 Cajones', 299990, NOW());

INSERT INTO regiones (id, nombre) VALUES  (1, "Sudamérica");
INSERT INTO regiones (id, nombre) VALUES  (2, "Centroamérica");
INSERT INTO regiones (id, nombre) VALUES  (3, "Norteamérica");
INSERT INTO regiones (id, nombre) VALUES  (4, "Europa");
INSERT INTO regiones (id, nombre) VALUES  (5, "Asia");
INSERT INTO regiones (id, nombre) VALUES  (6, "África");
INSERT INTO regiones (id, nombre) VALUES  (7, "Oceanía");
INSERT INTO regiones (id, nombre) VALUES  (8, "Antártida");

INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Andrés', 'Guzmán', 'profesor@gmail.com', CURDATE(), 1);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Luis', 'Venegas', 'lvenegas@gmail.com', CURDATE(), 1);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Karla', 'Solis', 'ksolis@gmail.com', CURDATE(), 1);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Melissa', 'Protti', 'mprotti@gmail.com', CURDATE(), 1);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Ronald', 'Palacios', 'rpalacios@gmail.com', CURDATE(), 1);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Pamela', 'Vargas', 'pvargas@gmail.com', CURDATE(), 1);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('John', 'Thompson', 'jthompson@gmail.com', CURDATE(), 1);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Laura', 'Salazar', 'lsalazar@gmail.com', CURDATE(), 1);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Andrea', 'Bravo', 'abravo@gmail.com', CURDATE(), 1);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Cristian', 'Smith', 'csmith@gmail.com', CURDATE(), 1);

INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client', 'testclient@gmail.com', CURDATE(), 2);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client2', 'testclient2@gmail.com', CURDATE(), 2);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client3', 'testclient3@gmail.com', CURDATE(), 2);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client4', 'testclient4@gmail.com', CURDATE(), 2);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client5', 'testclient5@gmail.com', CURDATE(), 2);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client6', 'testclient6@gmail.com', CURDATE(), 2);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client7', 'testclient7@gmail.com', CURDATE(), 2);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client8', 'testclient8@gmail.com', CURDATE(), 2);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client9', 'testclient9@gmail.com', CURDATE(), 2);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client10', 'testclient10@gmail.com', CURDATE(), 2);

INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client11', 'testclient11@gmail.com', CURDATE(), 3);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client12', 'testclient12@gmail.com', CURDATE(), 3);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client13', 'testclient13@gmail.com', CURDATE(), 3);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client14', 'testclient14@gmail.com', CURDATE(), 3);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client16', 'testclient16@gmail.com', CURDATE(), 3);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client17', 'testclient17@gmail.com', CURDATE(), 3);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client18', 'testclient18@gmail.com', CURDATE(), 3);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client19', 'testclient19@gmail.com', CURDATE(), 3);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client20', 'testclient20@gmail.com', CURDATE(), 3);

INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client21', 'testclient21@gmail.com', CURDATE(), 4);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client22', 'testclient22@gmail.com', CURDATE(), 4);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client23', 'testclient23@gmail.com', CURDATE(), 4);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client24', 'testclient24@gmail.com', CURDATE(), 4);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client25', 'testclient25@gmail.com', CURDATE(), 4);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client26', 'testclient26@gmail.com', CURDATE(), 4);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client27', 'testclient27@gmail.com', CURDATE(), 4);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client28', 'testclient28@gmail.com', CURDATE(), 4);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client29', 'testclient29@gmail.com', CURDATE(), 4);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client30', 'testclient30@gmail.com', CURDATE(), 4);

INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client31', 'testclient31@gmail.com', CURDATE(), 5);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client32', 'testclient32@gmail.com', CURDATE(), 5);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client33', 'testclient33@gmail.com', CURDATE(), 5);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client34', 'testclient34@gmail.com', CURDATE(), 5);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client35', 'testclient35@gmail.com', CURDATE(), 5);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client36', 'testclient36@gmail.com', CURDATE(), 5);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client37', 'testclient37@gmail.com', CURDATE(), 5);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client38', 'testclient38@gmail.com', CURDATE(), 5);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client39', 'testclient39@gmail.com', CURDATE(), 5);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client40', 'testclient40@gmail.com', CURDATE(), 5);

INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client41', 'testclient41@gmail.com', CURDATE(), 6);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client42', 'testclient42@gmail.com', CURDATE(), 6);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client43', 'testclient43@gmail.com', CURDATE(), 6);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client44', 'testclient44@gmail.com', CURDATE(), 6);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client45', 'testclient45@gmail.com', CURDATE(), 6);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client46', 'testclient46@gmail.com', CURDATE(), 5);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client47', 'testclient47@gmail.com', CURDATE(), 6);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client48', 'testclient48@gmail.com', CURDATE(), 6);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client49', 'testclient49@gmail.com', CURDATE(), 6);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client50', 'testclient50@gmail.com', CURDATE(), 6);

INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client51', 'testclient51@gmail.com', CURDATE(), 7);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client52', 'testclient52@gmail.com', CURDATE(), 7);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client53', 'testclient53@gmail.com', CURDATE(), 7);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client54', 'testclient54@gmail.com', CURDATE(), 7);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client55', 'testclient55@gmail.com', CURDATE(), 7);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client56', 'testclient56@gmail.com', CURDATE(), 7);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client57', 'testclient57@gmail.com', CURDATE(), 7);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client58', 'testclient58@gmail.com', CURDATE(), 7);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client59', 'testclient59@gmail.com', CURDATE(), 7);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client60', 'testclient60@gmail.com', CURDATE(), 7);

INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client61', 'testclient61@gmail.com', CURDATE(), 8);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client62', 'testclient62@gmail.com', CURDATE(), 8);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client63', 'testclient63@gmail.com', CURDATE(), 8);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client64', 'testclient64@gmail.com', CURDATE(), 8);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client65', 'testclient65@gmail.com', CURDATE(), 8);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client66', 'testclient66@gmail.com', CURDATE(), 8);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client67', 'testclient67@gmail.com', CURDATE(), 8);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client68', 'testclient68@gmail.com', CURDATE(), 8);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client69', 'testclient69@gmail.com', CURDATE(), 8);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client70', 'testclient70@gmail.com', CURDATE(), 8);

INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client71', 'testclient71@gmail.com', CURDATE(), 1);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client72', 'testclient72@gmail.com', CURDATE(), 1);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client73', 'testclient73@gmail.com', CURDATE(), 1);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client74', 'testclient74@gmail.com', CURDATE(), 1);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client75', 'testclient75@gmail.com', CURDATE(), 1);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client76', 'testclient76@gmail.com', CURDATE(), 1);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client77', 'testclient77@gmail.com', CURDATE(), 1);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client78', 'testclient78@gmail.com', CURDATE(), 1);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client79', 'testclient79@gmail.com', CURDATE(), 1);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client80', 'testclient80@gmail.com', CURDATE(), 1);

INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client81', 'testclient81@gmail.com', CURDATE(), 2);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client82', 'testclient82@gmail.com', CURDATE(), 2);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client83', 'testclient83@gmail.com', CURDATE(), 2);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client84', 'testclient84@gmail.com', CURDATE(), 2);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client85', 'testclient85@gmail.com', CURDATE(), 2);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client86', 'testclient86@gmail.com', CURDATE(), 2);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client87', 'testclient87@gmail.com', CURDATE(), 2);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client88', 'testclient88@gmail.com', CURDATE(), 2);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client89', 'testclient89@gmail.com', CURDATE(), 2);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client90', 'testclient90@gmail.com', CURDATE(), 2);

INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client91', 'testclient91@gmail.com', CURDATE(), 3);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client92', 'testclient92@gmail.com', CURDATE(), 3);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client93', 'testclient93@gmail.com', CURDATE(), 3);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client94', 'testclient94@gmail.com', CURDATE(), 3);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client95', 'testclient95@gmail.com', CURDATE(), 3);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client96', 'testclient96@gmail.com', CURDATE(), 3);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client97', 'testclient97@gmail.com', CURDATE(), 3);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client98', 'testclient98@gmail.com', CURDATE(), 3);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client99', 'testclient99@gmail.com', CURDATE(), 3);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client100', 'testclient100@gmail.com', CURDATE(), 3);

INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client101', 'testclient101@gmail.com', CURDATE(), 4);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client102', 'testclient102@gmail.com', CURDATE(), 4);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client103', 'testclient103@gmail.com', CURDATE(), 4);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client104', 'testclient104@gmail.com', CURDATE(), 4);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client105', 'testclient105@gmail.com', CURDATE(), 4);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client106', 'testclient106@gmail.com', CURDATE(), 4);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client107', 'testclient107@gmail.com', CURDATE(), 4);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client108', 'testclient108@gmail.com', CURDATE(), 4);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client109', 'testclient109@gmail.com', CURDATE(), 4);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client110', 'testclient110@gmail.com', CURDATE(), 4);

INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client111', 'testclient111@gmail.com', CURDATE(), 5);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client112', 'testclient112@gmail.com', CURDATE(), 5);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client113', 'testclient113@gmail.com', CURDATE(), 5);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client114', 'testclient114@gmail.com', CURDATE(), 5);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client115', 'testclient115@gmail.com', CURDATE(), 5);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client116', 'testclient116@gmail.com', CURDATE(), 5);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client117', 'testclient117@gmail.com', CURDATE(), 5);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client118', 'testclient118@gmail.com', CURDATE(), 5);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client119', 'testclient119@gmail.com', CURDATE(), 5);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Test', 'Client120', 'testclient120@gmail.com', CURDATE(), 5);

INSERT INTO facturas (descripcion, observacion, cliente_id, create_at) VALUES('Factura equipos de oficina', null, 1, NOW());
INSERT INTO facturas (descripcion, observacion, cliente_id, create_at) VALUES('Factura Bicicleta', 'Alguna nota importante!', 1, NOW());

INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 1);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(2, 1, 4);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 5);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 7);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(3, 2, 6);

