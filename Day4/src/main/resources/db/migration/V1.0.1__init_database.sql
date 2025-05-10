CREATE DATABASE IF NOT EXISTS employee_management_n0325c1;
USE employee_management_n0325c1;
drop database employee_management_n0325c1;

CREATE TABLE department
(
    id   INT AUTO_INCREMENT NOT NULL,
    name VARCHAR(255)       NULL,
    CONSTRAINT pk_department PRIMARY KEY (id)
);

CREATE TABLE employee
(
    id            BINARY(16)   PRIMARY KEY,
    name          VARCHAR(255) NOT NULL,
    dob           DATE         NOT NULL,
    gender        ENUM('MALE', 'FEMALE') NOT NULL,
    salary        DECIMAL(15, 2) NOT NULL,
    phone         VARCHAR(15),
    department_id INT,
    CONSTRAINT fk_department
        FOREIGN KEY (department_id)
            REFERENCES department (id)
);


