# create database customer_management_n0325c1;
# use customer_management_n0325c1;
# drop database customer_management_n0325c1;

CREATE TABLE khach_hang
(
    id             INT AUTO_INCREMENT NOT NULL,
    ten_khach_hang VARCHAR(255)       NULL,
    so_dien_thoai  VARCHAR(255)       NULL,
    email          VARCHAR(255)       NULL,
    CONSTRAINT pk_khachhang PRIMARY KEY (id)
);

CREATE TABLE giao_dich
(
    id             INT AUTO_INCREMENT NOT NULL,
    loai_dich_vu   VARCHAR(255)       NULL,
    ngay_giao_dich date               NULL,
    don_gia        DOUBLE             NULL,
    dien_tich      DOUBLE             NULL,
    khachhang_id   INT                NULL,
    CONSTRAINT pk_giaodich PRIMARY KEY (id)
);

ALTER TABLE giao_dich
    ADD CONSTRAINT FK_GIAODICH_ON_KHACHHANG FOREIGN KEY (khachhang_id) REFERENCES khach_hang (id);