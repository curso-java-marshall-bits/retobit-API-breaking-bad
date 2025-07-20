CREATE TABLE IF NOT EXISTS characters (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    occupation VARCHAR(255) NOT NULL,
    status VARCHAR(50) NOT NULL,
    image_url VARCHAR(255)
);

INSERT INTO characters (id, name, occupation, status, image_url) VALUES
(1, 'Walter White', 'Profesor de Química', 'DEAD', 'https://example.com/walter-white.jpg'),
(2, 'Jesse Pinkman', 'Ex-estudiante', 'DEAD', 'https://example.com/jesse-pinkman.jpg'),
(3, 'Skyler White', 'Contable', 'DEAD', 'https://example.com/skyler-white.jpg'),
(4, 'Hank Schrader', 'Agente DEA', 'DEAD', 'https://example.com/hank-schrader.jpg'),
(5, 'Marie Schrader', 'Técnico Radiológico', 'DEAD', 'https://example.com/marie-schrader.jpg'),
(6, 'Walter White Jr.', 'Estudiante', 'DEAD', 'https://example.com/walter-jr.jpg'),
(7, 'Saul Goodman', 'Abogado', 'DEAD', 'https://example.com/saul-goodman.jpg'),
(8, 'Mike Ehrmantraut', 'Ex-policía', 'DEAD', 'https://example.com/mike-ehrmantraut.jpg'),
(9, 'Gus Fring', 'Empresario', 'DEAD', 'https://example.com/gus-fring.jpg'),
(10, 'Tuco Salamanca', 'Distribuidor', 'DEAD', 'https://example.com/tuco-salamanca.jpg');