INSERT INTO app_user (username, password, role) VALUES
('admin', '$2b$10$htFezUL3BoardtIMqU3ffOjbasAGLqRkSCGz2kI5ryDNQkjMFUX3S', 'ADMIN');

INSERT INTO franchise (id, name) VALUES
(1, 'Franquicia Norte');

INSERT INTO branch (id, franchise_id, name) VALUES
(1, 1, 'Sucursal Centro'),
(2, 1, 'Sucursal Sur');

INSERT INTO product (branch_id, name, stock) VALUES
(1, 'Cafe Americano', 120),
(1, 'Sandwich Mixto', 45),
(2, 'Jugo Natural', 80),
(2, 'Ensalada Cesar', 30);
