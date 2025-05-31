-- Bảng admin
INSERT INTO admin (admin_id, full_name, email)
VALUES (1, 'Nguyen Van A', 'a.nguyen@example.com'),
       (2, 'Tran Thi B', 'b.tran@example.com'),
       (3, 'Le Van C', 'c.le@example.com'),
       (4, 'Pham Thi D', 'd.pham@example.com'),
       (5, 'Hoang Van E', 'e.hoang@example.com'),
       (6, 'Vu Thi F', 'f.vu@example.com'),
       (7, 'Do Van G', 'g.do@example.com'),
       (8, 'Bui Thi H', 'h.bui@example.com'),
       (9, 'Phan Van I', 'i.phan@example.com'),
       (10, 'Dang Thi J', 'j.dang@example.com');

-- Bảng book
INSERT INTO book (book_id, title, author, total_copies, available_copies, admin_id)
VALUES (1, 'Java Programming', 'James Gosling', 20, 15, 1),
       (2, 'Spring Framework', 'Rod Johnson', 15, 10, 2),
       (3, 'Database Systems', 'Abraham Silberschatz', 10, 5, 3),
       (4, 'Algorithms', 'Robert Sedgewick', 18, 14, 4),
       (5, 'Operating Systems', 'Andrew Tanenbaum', 12, 8, 5),
       (6, 'Network Security', 'William Stallings', 14, 11, 6),
       (7, 'Artificial Intelligence', 'Stuart Russell', 16, 12, 7),
       (8, 'Data Science Handbook', 'Field Cady', 10, 6, 8),
       (9, 'Clean Code', 'Robert C. Martin', 20, 17, 9),
       (10, 'Design Patterns', 'Erich Gamma', 22, 20, 10);

-- Bảng card
INSERT INTO card (card_id, issue_date, expiry_date)
VALUES (1, '2024-01-01', '2025-01-01'),
       (2, '2024-02-01', '2025-02-01'),
       (3, '2024-03-01', '2025-03-01'),
       (4, '2024-04-01', '2025-04-01'),
       (5, '2024-05-01', '2025-05-01'),
       (6, '2024-06-01', '2025-06-01'),
       (7, '2024-07-01', '2025-07-01'),
       (8, '2024-08-01', '2025-08-01'),
       (9, '2024-09-01', '2025-09-01'),
       (10, '2024-10-01', '2025-10-01');

-- Bảng student
INSERT INTO student (student_id, full_name, email, phone, dob, card_id)
VALUES (1, 'Le Thi Hoa', 'hoa.le@example.com', '0901234561', '2000-01-15', 1),
       (2, 'Tran Van Binh', 'binh.tran@example.com', '0901234562', '2000-02-20', 2),
       (3, 'Pham Thi Cam', 'cam.pham@example.com', '0901234563', '2000-03-25', 3),
       (4, 'Nguyen Van Dung', 'dung.nguyen@example.com', '0901234564', '2000-04-30', 4),
       (5, 'Hoang Thi Em', 'em.hoang@example.com', '0901234565', '2000-05-10', 5),
       (6, 'Vu Van Giang', 'giang.vu@example.com', '0901234566', '2000-06-15', 6),
       (7, 'Do Thi Ha', 'ha.do@example.com', '0901234567', '2000-07-20', 7),
       (8, 'Bui Van Khoa', 'khoa.bui@example.com', '0901234568', '2000-08-25', 8),
       (9, 'Phan Thi Lan', 'lan.phan@example.com', '0901234569', '2000-09-30', 9),
       (10, 'Dang Van Minh', 'minh.dang@example.com', '0901234570', '2000-10-05', 10);

-- Bảng loan
INSERT INTO loan (loan_id, borrow_date, due_date, return_date, status, student_id, book_id)
VALUES (1, '2025-04-01', '2025-04-15', '2025-04-14', 'DA_TRA', 1, 1),
       (2, '2025-04-05', '2025-04-19', NULL, 'MUON', 2, 2),
       (3, '2025-04-10', '2025-04-24', NULL, 'MUON', 3, 3),
       (4, '2025-04-12', '2025-04-26', '2025-04-25', 'DA_TRA', 4, 4),
       (5, '2025-04-15', '2025-04-29', NULL, 'MUON', 5, 5),
       (6, '2025-04-17', '2025-05-01', NULL, 'MUON', 6, 6),
       (7, '2025-04-20', '2025-05-04', '2025-05-02', 'DA_TRA', 7, 7),
       (8, '2025-04-22', '2025-05-06', NULL, 'MUON', 8, 8),
       (9, '2025-04-25', '2025-05-09', NULL, 'MUON', 9, 9),
       (10, '2025-04-28', '2025-05-12', NULL, 'MUON', 10, 10);

-- Bảng penalty
INSERT INTO penalty (penalty_id, days_overdue, amount, loan_id)
VALUES (1, 0, 0.0, 1),
       (2, 5, 25.0, 2),
       (3, 3, 15.0, 3),
       (4, 0, 0.0, 4),
       (5, 7, 35.0, 5),
       (6, 0, 0.0, 6),
       (7, 1, 5.0, 7),
       (8, 0, 0.0, 8),
       (9, 2, 10.0, 9),
       (10, 0, 0.0, 10);

-- Bảng damage_report
INSERT INTO damage_report (report_id, report_date, description, student_id, book_id)
VALUES (1, '2025-04-10', 'Bìa sách bị rách', 1, 1),
       (2, '2025-04-11', 'Trang sách bị mờ', 2, 2),
       (3, '2025-04-12', 'Sách mất trang', 3, 3),
       (4, '2025-04-13', 'Sách bị vấy bẩn', 4, 4),
       (5, '2025-04-14', 'Bìa sách bị tróc', 5, 5),
       (6, '2025-04-15', 'Sách bị nhàu', 6, 6),
       (7, '2025-04-16', 'Gáy sách bị nứt', 7, 7),
       (8, '2025-04-17', 'Sách bị rách góc', 8, 8),
       (9, '2025-04-18', 'Trang sách bị rách', 9, 9),
       (10, '2025-04-19', 'Sách bị mất bìa', 10, 10);
