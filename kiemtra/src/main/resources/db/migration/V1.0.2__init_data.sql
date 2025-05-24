# -- Thêm dữ liệu cho bảng khach_hang
# INSERT INTO khach_hang (ten_khach_hang, so_dien_thoai, email)
# VALUES ('Nguyen Van A', '0912345678', 'nguyenvana@example.com'),
#        ('Tran Thi B', '0987654321', 'tranthib@example.com'),
#        ('Le Van C', '0909123456', 'levanc@example.com');
#
# -- Giả sử ID tự tăng, ta sẽ dùng ID của khách hàng vừa tạo để chèn giao dịch
#
# -- Thêm dữ liệu cho bảng giao_dich
# INSERT INTO giao_dich (loai_dich_vu, ngay_giao_dich, don_gia, dien_tich, khachhang_id)
# VALUES ('Đất', '2025-05-10', 5000000, 100, 1),
#        ('Nhà và Đất', '2025-05-15', 7500000, 80, 2),
#        ('Đất', '2025-05-18', 6000000, 120, 3),
#        ('Nhà và Đất', '2025-05-20', 7000000, 90, 1);
