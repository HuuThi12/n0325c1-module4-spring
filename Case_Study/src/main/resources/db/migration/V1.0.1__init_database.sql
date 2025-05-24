# create database employee_management_n0325c1;
# use employee_management_n0325c1;
# drop database employee_management_n0325c1;

CREATE TABLE user
(
    id       BIGINT AUTO_INCREMENT NOT NULL,
    name     VARCHAR(255)          NULL,
    password VARCHAR(255)          NULL,
    CONSTRAINT pk_user PRIMARY KEY (id)
);

CREATE TABLE department
(
    id   INT AUTO_INCREMENT NOT NULL,
    name VARCHAR(255)       NULL,
    CONSTRAINT pk_department PRIMARY KEY (id)
);

CREATE TABLE employee
(
    id     BINARY(16)   NOT NULL,
    name   VARCHAR(255) NULL,
    dob    date         NULL,
    gender ENUM ('MALE', 'FEMALE') ,
    salary DECIMAL NULL, phone VARCHAR(255) NULL,
    department_id INT NULL, CONSTRAINT pk_employee PRIMARY KEY (id));

ALTER TABLE employee
    ADD CONSTRAINT FK_EMPLOYEE_ON_DEPARTMENT FOREIGN KEY (department_id) REFERENCES department (id);

# CREATE TABLE department
# (
#     id   INT AUTO_INCREMENT NOT NULL,
#     name VARCHAR(255)       NULL,
#     CONSTRAINT pk_department PRIMARY KEY (id)
# );
#
# CREATE TABLE employee
# (
#     id            BINARY(16)   PRIMARY KEY,
#     name          VARCHAR(255) NOT NULL,
#     dob           DATE         NOT NULL,
#     gender        ENUM('MALE', 'FEMALE') NOT NULL,
#     salary        DECIMAL(15, 2) NOT NULL,
#     phone         VARCHAR(15),
#     department_id INT,
#     CONSTRAINT fk_department
#         FOREIGN KEY (department_id)
#             REFERENCES department (id)
# );
#

