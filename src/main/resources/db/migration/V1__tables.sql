CREATE TABLE cars
(
    id_cars       BIGSERIAL PRIMARY KEY,
    make          VARCHAR(20) NOT NULL,
    model         VARCHAR(20) NOT NULL,
    year_of_issue INTEGER


);

CREATE TABLE users
(
    id_users BIGSERIAL PRIMARY KEY,
    name     VARCHAR(50) NOT NULL,
    email    VARCHAR(50) NOT NULL,
    password varchar(255)
);

