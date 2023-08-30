ALTER TABLE booking RENAME COLUMN status_begin TO start_of_lease;

ALTER TABLE booking RENAME COLUMN  status_end TO end_of_lease;