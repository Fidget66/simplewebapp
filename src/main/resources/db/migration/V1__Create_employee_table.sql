CREATE TABLE IF NOT EXISTS employee
(
    employee_id   bigserial NOT NULL,
    first_name    varchar,
    last_name     varchar,
    department_id bigint,
    job_title     varchar,
    gender        varchar,
    date_of_birth date,
    PRIMARY KEY (employee_id)
);