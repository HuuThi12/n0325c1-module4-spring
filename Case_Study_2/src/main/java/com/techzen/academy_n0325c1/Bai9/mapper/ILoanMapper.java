package com.techzen.academy_n0325c1.Bai9.mapper;

import com.techzen.academy_n0325c1.Bai9.dto.loan.LoanRequest;
import com.techzen.academy_n0325c1.Bai9.dto.loan.LoanResponse;
import com.techzen.academy_n0325c1.Bai9.model.Loan;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ILoanMapper {
//    @Mapping(source = "studentId", target = "student.studentId")
//    @Mapping(source = "bookId", target = "book.bookId")
    Loan loanRequestToLoan(LoanRequest loanRequest);

//    @Mapping(source = "student.studentId", target = "studentId")
//    @Mapping(source = "book.bookId", target = "bookId")
    LoanResponse loanToLoanResponse(Loan loan);

}