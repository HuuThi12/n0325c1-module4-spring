CREATE DATABASE Management;
use Management;
drop database Management;

create table Employee
(
    id           int auto_increment primary key,
    name         varchar(50),
    DOB          date,
    gender       varchar(10),
    salary       double,
    phone        varchar(20),
    departmentId int,
    FOREIGN KEY (id) REFERENCES Department (id)
);

create table Department
(
    id   int auto_increment primary key,
    name varchar(50)
);

insert into Department value (1, 'Quản lý');
insert into Department value (2, 'Kế Toán');
insert into Department value (3, 'Sale-Marketing');
insert into Department value (4, 'Sản xuất');



insert into Employee value (1, 'Hoàng Văn Hải', '1990-01-15', 'MALE', 15000000.00, '0975123542', 1);
insert into Employee value (2, 'Trần Thị Hoài', '1985-5-20', 'FEMALE', 14500000.00, '096786968', 2);
insert into Employee value (3, 'Lê Văn Sỹ', '1992-03-10', 'MALE', 15500000.00, '0988881110', 3);
insert into Employee value (4, 'Phạm Duy Khánh', '1988-07-15', 'FEMALE', 14800000.00, '0986555333', 4);

select * from Department;

