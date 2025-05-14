INSERT INTO user (name, password)
VALUES ('Alice', 'password123'),
       ('Bob', 'securepass'),
       ('Charlie', 'charliepwd');

INSERT INTO department (id, name)
VALUES (1, 'Quản lý'),
       (2, 'Kế toán'),
       (3, 'Sale-Marketing'),
       (4, 'Sản xuất');

INSERT INTO employee (id, name, dob, gender, salary, phone, department_id)
VALUES (UNHEX(REPLACE(UUID(), '-', '')), 'Hoàng Văn Hải', '1990-01-15', 1, 15000000.00, '0975123542', 1),
       (UNHEX(REPLACE(UUID(), '-', '')), 'Trần Thị Hoài', '1985-05-20', 2, 14500000.00, '0967869868', 2),
       (UNHEX(REPLACE(UUID(), '-', '')), 'Lê Văn Sỹ', '1992-03-10', 1, 15000000.00, '0988881111', 3),
       (UNHEX(REPLACE(UUID(), '-', '')), 'Phạm Duy Khánh', '1988-07-05', 1, 14000000.00, '0965535333', 4);