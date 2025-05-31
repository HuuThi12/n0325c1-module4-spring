-- Insert data into admin table
INSERT INTO admin (admin_id, full_name, email)
VALUES (1, 'John Doe', 'johndoe@example.com'),
       (2, 'Jane Smith', 'janesmith@example.com'),
       (3, 'Mark Johnson', 'markjohnson@example.com'),
       (4, 'Emily Davis', 'emilydavis@example.com'),
       (5, 'Michael Brown', 'michaelbrown@example.com'),
       (6, 'Sarah Wilson', 'sarahwilson@example.com'),
       (7, 'David Moore', 'davidmoore@example.com'),
       (8, 'Laura Taylor', 'laurataylor@example.com'),
       (9, 'James Anderson', 'jamesanderson@example.com'),
       (10, 'Patricia Thomas', 'patriciathomas@example.com');

-- Insert data into card table
INSERT INTO card (card_id, issue_date, expiry_date)
VALUES (1, '2023-01-15', '2025-01-15'),
       (2, '2023-02-20', '2025-02-20'),
       (3, '2023-03-25', '2025-03-25'),
       (4, '2023-04-30', '2025-04-30'),
       (5, '2023-05-10', '2025-05-10'),
       (6, '2023-06-15', '2025-06-15'),
       (7, '2023-07-20', '2025-07-20'),
       (8, '2023-08-25', '2025-08-25'),
       (9, '2023-09-10', '2025-09-10'),
       (10, '2023-10-05', '2025-10-05');

-- Insert data into student table
INSERT INTO student (student_id, full_name, email, phone, dob, card_id)
VALUES (1, 'Alice Williams', 'alice@example.com', '1234567890', '2000-01-15', 1),
       (2, 'Bob Smith', 'bob@example.com', '1234567891', '1999-02-20', 2),
       (3, 'Charlie Brown', 'charlie@example.com', '1234567892', '1998-03-25', 3),
       (4, 'Diana Green', 'diana@example.com', '1234567893', '2001-04-30', 4),
       (5, 'Edward Johnson', 'edward@example.com', '1234567894', '2002-05-10', 5),
       (6, 'Fiona Clarke', 'fiona@example.com', '1234567895', '2000-06-15', 6),
       (7, 'George Harris', 'george@example.com', '1234567896', '1999-07-20', 7),
       (8, 'Hannah Scott', 'hannah@example.com', '1234567897', '1998-08-25', 8),
       (9, 'Ian Adams', 'ian@example.com', '1234567898', '2001-09-10', 9),
       (10, 'Jack King', 'jack@example.com', '1234567899', '2002-10-05', 10);

-- Insert data into book table
INSERT INTO book (book_id, title, author, total_copies, available_copies)
VALUES (1, 'The Great Gatsby', 'F. Scott Fitzgerald', 10, 8),
       (2, '1984', 'George Orwell', 15, 10),
       (3, 'To Kill a Mockingbird', 'Harper Lee', 20, 15),
       (4, 'Pride and Prejudice', 'Jane Austen', 12, 9),
       (5, 'Moby-Dick', 'Herman Melville', 8, 6),
       (6, 'War and Peace', 'Leo Tolstoy', 25, 20),
       (7, 'The Catcher in the Rye', 'J.D. Salinger', 18, 14),
       (8, 'The Odyssey', 'Homer', 30, 25),
       (9, 'The Hobbit', 'J.R.R. Tolkien', 22, 18),
       (10, 'Frankenstein', 'Mary Shelley', 16, 12);

-- Insert data into damage_report table
INSERT INTO damage_report (report_id, student_id, book_id, report_date, description)
VALUES (1, 1, 1, '2023-05-01', 'Cover torn'),
       (2, 2, 2, '2023-05-02', 'Pages missing'),
       (3, 3, 3, '2023-05-03', 'Spine broken'),
       (4, 4, 4, '2023-05-04', 'Stains on pages'),
       (5, 5, 5, '2023-05-05', 'Pages wrinkled'),
       (6, 6, 6, '2023-05-06', 'Cover damaged'),
       (7, 7, 7, '2023-05-07', 'Bent corner'),
       (8, 8, 8, '2023-05-08', 'Pages scribbled'),
       (9, 9, 9, '2023-05-09', 'Missing pages'),
       (10, 10, 10, '2023-05-10', 'Water damage');

-- Insert data into loan table
INSERT INTO loan (loan_id, book_book_id, borrow_date, due_date, return_date, status)
VALUES (1, 1, '2023-04-01', '2023-04-15', '2023-04-14', 'Returned'),
       (2, 2, '2023-04-05', '2023-04-19', '2023-04-18', 'Returned'),
       (3, 3, '2023-04-10', '2023-04-24', '2023-04-23', 'Returned'),
       (4, 4, '2023-04-12', '2023-04-26', '2023-04-25', 'Returned'),
       (5, 5, '2023-04-15', '2023-04-29', '2023-04-28', 'Returned'),
       (6, 6, '2023-04-18', '2023-05-02', '2023-05-01', 'Returned'),
       (7, 7, '2023-04-20', '2023-05-04', '2023-05-03', 'Returned'),
       (8, 8, '2023-04-22', '2023-05-06', '2023-05-05', 'Returned'),
       (9, 9, '2023-04-25', '2023-05-09', '2023-05-08', 'Returned'),
       (10, 10, '2023-04-30', '2023-05-14', '2023-05-13', 'Returned');

-- Insert data into penalty table
INSERT INTO penalty (penalty_id, loan_id, days_overdue, amount)
VALUES (1, 1, 2, 5.00),
       (2, 2, 3, 7.50),
       (3, 3, 1, 2.50),
       (4, 4, 4, 10.00),
       (5, 5, 5, 12.50),
       (6, 6, 2, 5.00),
       (7, 7, 3, 7.50),
       (8, 8, 1, 2.50),
       (9, 9, 4, 10.00),
       (10, 10, 5, 12.50);
