CREATE TABLE admin
(
    id            BIGSERIAL PRIMARY KEY,
    name          VARCHAR(30) NOT NULL,
    email         varchar(30) NOT NULL,
    password_hash VARCHAR(50) NOT NULL
);

CREATE TABLE "user"
(
    id            BIGSERIAL PRIMARY KEY,
    name          VARCHAR(30) NOT NULL,
    email         VARCHAR(30) NOT NULL,
    password_hash VARCHAR(50) NOT NULL


);

CREATE UNIQUE INDEX ON "user" (lower(email));



CREATE TABLE car
(
    id            BIGSERIAL PRIMARY KEY,
    brand         VARCHAR(20) NOT NULL,
    model         VARCHAR(20) NOT NULL,
    price         DECIMAL     NOT NULL,
    created_at    TIMESTAMP   NOT NULL,
    active_status BOOLEAN     NOT NULL,
    admin_id      BIGINT      NOT NULL REFERENCES admin (id)


);



CREATE TABLE car_reservation
(
    id         BIGSERIAL PRIMARY KEY,
    message    VARCHAR(150) NOT NULL,
    start_date DATE         NOT NULL,
    end_date   DATE         NOT NULL,
    created_at TIMESTAMP    NOT NULL,
    user_id    BIGINT       NOT NULL REFERENCES "user" (id),
    car_id     BIGINT       NOT NULL REFERENCES car (id),
    UNIQUE (user_id, car_id)

);