

-- Chèn dữ liệu vào bảng department
# INSERT INTO department (id, name)
# VALUES
#     (1, 'Quản lý'),
#     (2, 'Kế toán'),
#     (3, 'Sale-Marketing'),
#     (4, 'Sản xuất');

-- Tạo bảng employee
-- Tạo bảng employee
# CREATE TABLE employee
# (
#     id            BINARY(16)   NOT NULL,
#     name          VARCHAR(255) NULL,
#     dob           date         NULL,
#     gender        SMALLINT     NULL,
#     salary        DOUBLE       NOT NULL,
#     phone         VARCHAR(255) NULL,
#     department_id INT          NULL,
#     CONSTRAINT pk_employee PRIMARY KEY (id)
# );
# drop table employee;
# -- Trigger để tạo UUID cho employee nếu null
# DELIMITER $$
# CREATE TRIGGER before_insert_employee
#     BEFORE INSERT
#     ON employee
#     FOR EACH ROW
# BEGIN
#     IF NEW.id IS NULL THEN
#         SET NEW.id = UUID();
# END IF;
# END$$
# DELIMITER ;

-- Chèn dữ liệu vào bảng employee
# INSERT INTO employee (id, name, dob, gender, salary, phone, department_id)
# VALUES
#     (UNHEX(REPLACE(UUID(), '-', '')), 'Hoàng Văn Hải', '1990-01-15', 1, 15000000.00, '0975123542', 1),
#     (UNHEX(REPLACE(UUID(), '-', '')), 'Trần Thị Hoài', '1985-05-20', 2, 14500000.00, '0967869868', 2),
#     (UNHEX(REPLACE(UUID(), '-', '')), 'Lê Văn Sỹ', '1992-03-10', 1, 15000000.00, '0988881111', 3),
#     (UNHEX(REPLACE(UUID(), '-', '')), 'Phạm Duy Khánh', '1988-07-05', 1, 14000000.00, '0965535333', 4);
# select * from department;
# select * from employee;

