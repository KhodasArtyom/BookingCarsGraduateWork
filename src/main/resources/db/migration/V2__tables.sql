CREATE TABLE booking
(
    id_booking   BIGSERIAL PRIMARY KEY,
    id_cars      INTEGER   NOT NULL REFERENCES cars,
    id_users     INTEGER   NOT NULL REFERENCES users,
    status_begin TIMESTAMP NOT NULL,
    status_end   TIMESTAMP NOT NULL

);