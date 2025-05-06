create database employee_management;
use employee_management;

-- Tạo bảng department
CREATE TABLE department
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL
);

-- Chèn dữ liệu vào bảng department
INSERT INTO department (id, name)
VALUES
    (1, 'Quản lý'),
    (2, 'Kế toán'),
    (3, 'Sale-Marketing'),
    (4, 'Sản xuất');

-- Tạo bảng employee
CREATE TABLE employee
(
    id CHAR(36) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    dob DATE NOT NULL,
    gender ENUM('MALE', 'FEMALE') NOT NULL,
    salary DECIMAL(15,2) NOT NULL,
    phone VARCHAR(15) NOT NULL,
    department_id INT,
    CONSTRAINT fk_department
        FOREIGN KEY (department_id)
            REFERENCES department (id)
);

-- Trigger để tạo UUID cho employee nếu null
DELIMITER $$
CREATE TRIGGER before_insert_employee
    BEFORE INSERT
    ON employee
    FOR EACH ROW
BEGIN
    IF NEW.id IS NULL THEN
        SET NEW.id = UUID();
END IF;
END$$
DELIMITER ;

-- Chèn dữ liệu vào bảng employee
INSERT INTO employee (id, name, dob, gender, salary, phone, department_id)
VALUES
    (id UUID(), name 'Hoàng Văn Hải', dob '1990-01-15', gender 'MALE', salary 15000000.00, phone '0975123542', department_id 1),
    (id UUID(), name 'Trần Thị Hoài', dob '1985-05-20', gender 'FEMALE', salary 14500000.00, phone '0967869868', department_id 2),
    (id UUID(), name 'Lê Văn Sỹ', dob '1992-03-10', gender 'MALE', salary 15000000.00, phone '0988881111', department_id 3),
    (id UUID(), name 'Phạm Duy Khánh', dob '1988-07-05', gender 'MALE', salary 14000000.00, phone '0965535333', department_id 4),
    (id UUID(), name 'Hoàng Văn Quang', dob '1995-09-25', gender 'MALE', salary 15000000.00, phone '0973388686', department_id 5);

