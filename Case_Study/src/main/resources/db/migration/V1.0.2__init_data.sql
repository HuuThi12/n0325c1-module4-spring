-- Bảng admin
INSERT INTO admin (admin_id, full_name, email)
VALUES (1, 'Nguyen Van A', 'a.nguyen@example.com'),
       (2, 'Tran Thi B', 'b.tran@example.com'),
       (3, 'Le Van C', 'c.le@example.com'),
       (4, 'Pham Thi D', 'd.pham@example.com'),
       (5, 'Hoang Van E', 'e.hoang@example.com'),
       (6, 'Vu Thi F', 'f.vu@example.com'),
       (7, 'Do Van G', 'g.do@example.com'),
       (8, 'Ngo Thi H', 'h.ngo@example.com'),
       (9, 'Bui Van I', 'i.bui@example.com'),
       (10, 'Mai Thi K', 'k.mai@example.com');

-- Bảng book
INSERT INTO book (book_id, title, author, total_copies, available_copies)
VALUES (1, 'Java Programming', 'Nguyen Van A', 10, 7),
       (2, 'Database Systems', 'Tran Thi B', 8, 3),
       (3, 'Web Design', 'Le Van C', 6, 6),
       (4, 'English Basics', 'Pham Thi D', 15, 10),
       (5, 'Advanced Math', 'Hoang Van E', 7, 5),
       (6, 'Programming Techniques', 'Vu Thi F', 12, 9),
       (7, 'Information Security', 'Do Van G', 9, 8),
       (8, 'Microeconomics', 'Ngo Thi H', 4, 4),
       (9, 'System Management', 'Bui Van I', 5, 2),
       (10, 'Physical Education', 'Mai Thi K', 11, 11);

-- Bảng card
INSERT INTO card (card_id, issue_date, expiry_date)
VALUES (101, '2024-01-01', '2025-01-01'),
       (102, '2024-01-05', '2025-01-05'),
       (103, '2024-01-10', '2025-01-10'),
       (104, '2024-01-15', '2025-01-15'),
       (105, '2024-01-20', '2025-01-20'),
       (106, '2024-01-25', '2025-01-25'),
       (107, '2024-01-30', '2025-01-30'),
       (108, '2024-02-04', '2025-02-04'),
       (109, '2024-02-09', '2025-02-09'),
       (110, '2024-02-14', '2025-02-14');

-- Bảng student
INSERT INTO student (student_id, full_name, email, phone, dob, card_id)
VALUES (201, 'Tran Van X', 'x.tran@example.com', '0123456789', '2000-05-15', 101),
       (202, 'Le Thi Y', 'y.le@example.com', '0987654321', '2001-06-20', 102),
       (203, 'Pham Van Z', 'z.pham@example.com', '0112233445', '1999-07-25', 103),
       (204, 'Ngo Thi W', 'w.ngo@example.com', '0223344556', '2002-08-30', 104),
       (205, 'Bui Van V', 'v.bui@example.com', '0334455667', '2000-09-05', 105),
       (206, 'Do Thi U', 'u.do@example.com', '0445566778', '2001-10-10', 106),
       (207, 'Hoang Van T', 't.hoang@example.com', '0556677889', '1998-11-15', 107),
       (208, 'Vu Thi S', 's.vu@example.com', '0667788990', '2002-12-20', 108),
       (209, 'Mai Van R', 'r.mai@example.com', '0778899001', '2000-01-25', 109),
       (210, 'Tran Thi Q', 'q.tran@example.com', '0889900112', '1999-02-28', 110);

-- Bảng damage_report
INSERT INTO damage_report (report_id, student_id, book_id, report_date, description)
VALUES (301, 201, 1, '2024-04-15', 'Torn pages'),
       (302, 202, 2, '2024-04-16', 'Cover damaged'),
       (303, 203, 3, '2024-04-17', 'Pages missing'),
       (304, 204, 4, '2024-04-18', 'Water damage'),
       (305, 205, 5, '2024-04-19', 'Spine broken'),
       (306, 206, 6, '2024-04-20', 'Notes written inside'),
       (307, 207, 7, '2024-04-21', 'Pages folded'),
       (308, 208, 8, '2024-04-22', 'Cover torn'),
       (309, 209, 9, '2024-04-23', 'Stains on pages'),
       (310, 210, 10, '2024-04-24', 'Missing back cover');

-- Bảng loan
INSERT INTO loan (loan_id, student_id, book_id, borrow_date, due_date, return_date, status)
VALUES (401, 201, 1, '2024-04-01', '2024-04-10', NULL, 'Borrowed'),
       (402, 202, 2, '2024-04-02', '2024-04-11', '2024-04-10', 'Returned'),
       (403, 203, 3, '2024-04-03', '2024-04-12', NULL, 'Borrowed'),
       (404, 204, 4, '2024-04-04', '2024-04-13', '2024-04-12', 'Returned'),
       (405, 205, 5, '2024-04-05', '2024-04-14', NULL, 'Borrowed'),
       (406, 206, 6, '2024-04-06', '2024-04-15', '2024-04-14', 'Returned'),
       (407, 207, 7, '2024-04-07', '2024-04-16', NULL, 'Borrowed'),
       (408, 208, 8, '2024-04-08', '2024-04-17', '2024-04-16', 'Returned'),
       (409, 209, 9, '2024-04-09', '2024-04-18', NULL, 'Borrowed'),
       (410, 210, 10, '2024-04-10', '2024-04-19', '2024-04-18', 'Returned');

-- Bảng penalty
INSERT INTO penalty (penalty_id, loan_id, days_overdue, amount)
VALUES (501, 402, 1, 10.0),
       (502, 404, 1, 10.0),
       (503, 406, 1, 10.0),
       (504, 408, 1, 10.0),
       (505, 410, 1, 10.0),
       (506, NULL, 0, 0.0),
       (507, NULL, 0, 0.0),
       (508, NULL, 0, 0.0),
       (509, NULL, 0, 0.0),
       (510, NULL, 0, 0.0);
