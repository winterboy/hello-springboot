
INSERT INTO country (id, name) VALUES (1, 'USA');
INSERT INTO country (id, name) VALUES (2, 'France');
INSERT INTO country (id, name) VALUES (3, 'Brazil');

--INSERT INTO users (username, password, roles) VALUES ('hehe', '$2a$10$0gzEKAda2gD0XPwU7Jqg6.WtDCp1q54yx.Ps7ngyQzhOD71qHfYu2', 'USER');
--INSERT INTO users (username, password, roles) VALUES ('admin', '$2a$10$Vu/aYaUkA4rAg8KA/Zkv2OA8hl1SlKgMPcmhCGA/yW1WnCLQn4/rC', 'ADMIN');


INSERT INTO users (username, password, enabled) VALUES ('hehe', '$2a$10$0gzEKAda2gD0XPwU7Jqg6.WtDCp1q54yx.Ps7ngyQzhOD71qHfYu2', true);
INSERT INTO users (username, password, enabled) VALUES ('admin', '$2a$10$Vu/aYaUkA4rAg8KA/Zkv2OA8hl1SlKgMPcmhCGA/yW1WnCLQn4/rC', true);

INSERT INTO authorities (username, authority) VALUES ('hehe', 'USER');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ADMIN');
