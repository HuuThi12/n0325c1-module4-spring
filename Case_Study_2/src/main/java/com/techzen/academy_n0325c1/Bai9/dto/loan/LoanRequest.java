package com.techzen.academy_n0325c1.Bai9.dto.loan;

import com.techzen.academy_n0325c1.Bai9.dto.book.BookRequest;
import com.techzen.academy_n0325c1.Bai9.dto.student.StudentRequest;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoanRequest {
    Integer loanId;
    StudentRequest student;
    BookRequest book;
    LocalDate borrowDate;
    LocalDate dueDate;
    String status;
}