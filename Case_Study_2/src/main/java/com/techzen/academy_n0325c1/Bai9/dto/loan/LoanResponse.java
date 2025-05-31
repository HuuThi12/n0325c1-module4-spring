package com.techzen.academy_n0325c1.Bai9.dto.loan;

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
    Integer studentId;
    Integer bookId;
    LocalDate borrowDate;
    LocalDate dueDate;
    LocalDate returnDate;
    String status;
}