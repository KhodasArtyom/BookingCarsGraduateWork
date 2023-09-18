CREATE TABLE admin
(
    id_admin BIGSERIAL PRIMARY KEY,
    username VARCHAR(30) NOT NULL,
    password VARCHAR(50) NOT NULL,
    email    VARCHAR(50) NOT NULL
);



CREATE TABLE car
(
    id_car        BIGSERIAL PRIMARY KEY,
    brand         VARCHAR(20)    NOT NULL,
    model         VARCHAR(20)    NOT NULL,
    year_of_issue BIGINT         NOT NULL,
    price         DECIMAL(10, 2) NOT NULL,
    status        BOOLEAN DEFAULT TRUE


);

CREATE TABLE users
(
    id_user  BIGSERIAL PRIMARY KEY,
    username VARCHAR(30) NOT NULL UNIQUE,
    password VARCHAR(80) NOT NULL,
    email    VARCHAR(50) NOT NULL UNIQUE


);

CREATE TABLE car_reservation
(
    id_reservation     BIGSERIAL PRIMARY KEY,
    id_car             BIGINT                       NOT NULL,
    id_user            BIGINT                       NOT NULL,
    start_date         DATE                         NOT NULL,
    end_date           DATE                         NOT NULL,
    total_price        DECIMAL                      NOT NULL,
    reservation_status VARCHAR(20) DEFAULT 'BOOKED' NOT NULL,

    FOREIGN KEY (id_car) REFERENCES car (id_car),
    FOREIGN KEY (id_user) REFERENCES users (id_user)

);







