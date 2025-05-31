package com.techzen.academy_n0325c1.Bai9.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum Errorcode {
    STUDENT_NOT_EXITS(40401, "Student is not exist!", HttpStatus.NOT_FOUND),
    ADMIN_NOT_EXITS(40402, "Admin is not exist!", HttpStatus.NOT_FOUND),
    BOOK_NOT_EXITS(40403, "Book is not exist!", HttpStatus.NOT_FOUND),
    CARD_NOT_EXITS(40404, "Card is not exist!", HttpStatus.NOT_FOUND),
    LOAN_NOT_EXITS(40405, "Loan is not exist!", HttpStatus.NOT_FOUND),
    PENALTY_NOT_EXITS(40406, "Penalty is not exist!", HttpStatus.NOT_FOUND),
    DAMAGE_REPORT_NOT_EXITS(40406, "Damage Report is not exist!", HttpStatus.NOT_FOUND);


    int code;
    String message;
    HttpStatus status;

}

