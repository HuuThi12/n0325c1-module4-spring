# create database library_management_n0325c1;
# use library_management_n0325c1;
# drop database library_management_n0325c1;

CREATE TABLE `admin`
(
    admin_id  INT          NOT NULL,
    full_name VARCHAR(255) NULL,
    email     VARCHAR(255) NULL,
    CONSTRAINT pk_admin PRIMARY KEY (admin_id)
);

CREATE TABLE book
(
    book_id          INT          NOT NULL,
    title            VARCHAR(255) NULL,
    author           VARCHAR(255) NULL,
    total_copies     INT          NULL,
    available_copies INT          NULL,
    CONSTRAINT pk_book PRIMARY KEY (book_id)
);

CREATE TABLE card
(
    card_id     INT  NOT NULL,
    issue_date  date NULL,
    expiry_date date NULL,
    CONSTRAINT pk_card PRIMARY KEY (card_id)
);

CREATE TABLE damage_report
(
    report_id     INT          NOT NULL,
    student_id    INT          NULL,
    book_id       INT          NULL,
    report_date   date         NULL,
    `description` VARCHAR(255) NULL,
    CONSTRAINT pk_damagereport PRIMARY KEY (report_id)
);

CREATE TABLE loan
(
    loan_id      INT          NOT NULL,
    book_book_id INT          NULL,
    borrow_date  date         NULL,
    due_date     date         NULL,
    return_date  date         NULL,
    status       VARCHAR(255) NULL,
    CONSTRAINT pk_loan PRIMARY KEY (loan_id)
);

CREATE TABLE penalty
(
    penalty_id   INT    NOT NULL,
    loan_id      INT    NULL,
    days_overdue INT    NULL,
    amount       DOUBLE NULL,
    CONSTRAINT pk_penalty PRIMARY KEY (penalty_id)
);

CREATE TABLE student
(
    student_id INT          NOT NULL,
    full_name  VARCHAR(255) NULL,
    email      VARCHAR(255) NULL,
    phone      VARCHAR(255) NULL,
    dob        date         NULL,
    card_id    INT          NULL,
    CONSTRAINT pk_student PRIMARY KEY (student_id)
);

ALTER TABLE student
    ADD CONSTRAINT uc_student_card UNIQUE (card_id);

ALTER TABLE damage_report
    ADD CONSTRAINT FK_DAMAGEREPORT_ON_BOOK FOREIGN KEY (book_id) REFERENCES book (book_id);

ALTER TABLE damage_report
    ADD CONSTRAINT FK_DAMAGEREPORT_ON_STUDENT FOREIGN KEY (student_id) REFERENCES student (student_id);

ALTER TABLE loan
    ADD CONSTRAINT FK_LOAN_ON_BOOK_BOOKID FOREIGN KEY (book_book_id) REFERENCES book (book_id);

ALTER TABLE penalty
    ADD CONSTRAINT FK_PENALTY_ON_LOAN FOREIGN KEY (loan_id) REFERENCES loan (loan_id);

ALTER TABLE student
    ADD CONSTRAINT FK_STUDENT_ON_CARD FOREIGN KEY (card_id) REFERENCES card (card_id);
