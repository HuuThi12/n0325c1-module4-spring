create database employee_management;
use employee_management;
drop database employee_management;
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
    (UUID(), 'Hoàng Văn Hải', '1990-01-15', 'MALE', 15000000.00, '0975123542', 1),
    (UUID(), 'Trần Thị Hoài', '1985-05-20', 'FEMALE', 14500000.00, '0967869868', 2),
    (UUID(), 'Lê Văn Sỹ', '1992-03-10', 'MALE', 15000000.00, '0988881111', 3),
    (UUID(), 'Phạm Duy Khánh', '1988-07-05', 'MALE', 14000000.00, '0965535333', 4);

select * from department;
select * from employee;

