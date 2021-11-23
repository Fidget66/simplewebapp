DROP TABLE IF EXISTS employee;

CREATE TABLE IF NOT EXISTS employee(
    employee_id bigserial NOT NULL,
    first_name varchar,
    last_name varchar,
    department_id bigint,
    job_title varchar,
    gender varchar,
    date_of_birth date,
    PRIMARY KEY (employee_id)
);

INSERT INTO employee (first_name, last_name, department_id, job_title, gender, date_of_birth)
values ('Petr', 'Ivanov', 2, 'Professor','MALE','1980-03-12');
INSERT INTO employee (first_name, last_name, department_id, job_title, gender, date_of_birth)
values ('Olga', 'Lee', 6,'Lab assistant', 'FEMALE','1985-04-22');
INSERT INTO employee (first_name, last_name, department_id, job_title, gender, date_of_birth)
values ('Andrey', 'Andreev', 6,'Technical Support','MALE','1993-12-24');
