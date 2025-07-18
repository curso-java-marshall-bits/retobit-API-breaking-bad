-- Crear tabla 'characters'
CREATE TABLE IF NOT EXISTS characters (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    occupation VARCHAR(255) NOT NULL,
    status VARCHAR(50) NOT NULL,
    image_url VARCHAR(255)
);

-- Crear tabla 'character_seasons'
CREATE TABLE IF NOT EXISTS character_seasons (
    character_id BIGINT NOT NULL,
    season INT NOT NULL,
    FOREIGN KEY (character_id) REFERENCES characters(id)
);

-- Insertar personajes de Breaking Bad
INSERT INTO characters (id, name, occupation, status, image_url) VALUES
(1, 'Walter White', 'Profesor de Química', 'DEAD', 'https://example.com/walter-white.jpg'),
(2, 'Jesse Pinkman', 'Ex-estudiante', 'ALIVE', 'https://example.com/jesse-pinkman.jpg'),
(3, 'Skyler White', 'Contable', 'ALIVE', 'https://example.com/skyler-white.jpg'),
(4, 'Hank Schrader', 'Agente DEA', 'DEAD', 'https://example.com/hank-schrader.jpg'),
(5, 'Marie Schrader', 'Técnico Radiológico', 'DEAD', 'https://example.com/marie-schrader.jpg'),
(6, 'Walter White Jr.', 'Estudiante', 'DEAD', 'https://example.com/walter-jr.jpg'),
(7, 'Saul Goodman', 'Abogado', 'DEAD', 'https://example.com/saul-goodman.jpg'),
(8, 'Mike Ehrmantraut', 'Ex-policía', 'DEAD', 'https://example.com/mike-ehrmantraut.jpg'),
(9, 'Gus Fring', 'Empresario', 'DEAD', 'https://example.com/gus-fring.jpg'),
(10, 'Tuco Salamanca', 'Distribuidor', 'DEAD', 'https://example.com/tuco-salamanca.jpg');

-- Insertar temporadas para cada personaje
INSERT INTO character_seasons (character_id, season) VALUES
-- Walter White (1,2,3,4,5)
(1, 1), (1, 2), (1, 3), (1, 4), (1, 5),
-- Jesse Pinkman (1,2,3,4,5)
(2, 1), (2, 2), (2, 3), (2, 4), (2, 5),
-- Skyler White (1,2,3,4,5)
(3, 1), (3, 2), (3, 3), (3, 4), (3, 5),
-- Hank Schrader (1,2,3,4,5)
(4, 1), (4, 2), (4, 3), (4, 4), (4, 5),
-- Marie Schrader (1,2,3,4,5)
(5, 1), (5, 2), (5, 3), (5, 4), (5, 5),
-- Walter White Jr. (1,2,3,4,5)
(6, 1), (6, 2), (6, 3), (6, 4), (6, 5),
-- Saul Goodman (2,3,4,5)
(7, 2), (7, 3), (7, 4), (7, 5),
-- Mike Ehrmantraut (2,3,4,5)
(8, 2), (8, 3), (8, 4), (8, 5),
-- Gus Fring (2,3,4)
(9, 2), (9, 3), (9, 4),
-- Tuco Salamanca (1,2)
(10, 1), (10, 2);
