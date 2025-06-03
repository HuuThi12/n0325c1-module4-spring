package com.techzen.academy_n0325c1.Bai9.dto.loan;

import com.techzen.academy_n0325c1.Bai9.dto.book.BookResponse;
import com.techzen.academy_n0325c1.Bai9.dto.student.StudentResponse;
import com.techzen.academy_n0325c1.Bai9.model.Student;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoanResponse {
    Integer loanId;
    StudentResponse student;
    BookResponse book;
    LocalDate borrowDate;
    LocalDate dueDate;
    LocalDate returnDate;
    String status;
}