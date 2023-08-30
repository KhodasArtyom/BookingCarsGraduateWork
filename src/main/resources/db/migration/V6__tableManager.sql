CREATE TABLE manager
(
    id_manager BIGSERIAL PRIMARY KEY,
    name     VARCHAR(50) NOT NULL,
    email    VARCHAR(50) NOT NULL,
    password varchar(255)
);