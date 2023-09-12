ALTER TABLE cars ADD column booking_status BOOLEAN;

ALTER TABLE cars ADD column admin_id BIGINT  REFERENCES admin(id_admin) ;