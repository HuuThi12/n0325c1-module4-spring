package com.techzen.academy_n0325c1.Bai9.controller;


import com.techzen.academy_n0325c1.Bai9.dto.ApiResponse;
import com.techzen.academy_n0325c1.Bai9.dto.loan.LoanRequest;
import com.techzen.academy_n0325c1.Bai9.dto.loan.LoanResponse;
import com.techzen.academy_n0325c1.Bai9.dto.page.PageResponse;
import com.techzen.academy_n0325c1.Bai9.exception.AppException;
import com.techzen.academy_n0325c1.Bai9.exception.Errorcode;
import com.techzen.academy_n0325c1.Bai9.mapper.ILoanMapper;
import com.techzen.academy_n0325c1.Bai9.model.Loan;
import com.techzen.academy_n0325c1.Bai9.service.ILoanService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/loans")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class LoanController {
    ILoanService loanService;
    ILoanMapper loanMapper;

    @GetMapping
    public ResponseEntity<ApiResponse<PageResponse<LoanResponse>>> getLoans(
            @RequestParam(defaultValue = "") LocalDate borrowDate,
            LocalDate dueDate, LocalDate returnDate, Pageable pageable) {
        return ResponseEntity.ok(ApiResponse.<PageResponse<LoanResponse>>builder()
                .data(new PageResponse<>(loanService.findByAttr(borrowDate, dueDate, returnDate, pageable)
                        .map(loanMapper::loanToLoanResponse)))
                .build());
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody LoanRequest loanRequest) {
        // B1: chuyển từ request sang entity
        Loan loan = loanMapper.loanRequestToLoan(loanRequest);
        // B2: Lưu Entity xuống DB
        loan = loanService.save(loan);
        // B3: Chuyển Entity về AdminResponse
        LoanResponse loanResponse = loanMapper.loanToLoanResponse(loan);
        //B4: return về StudentResponse
        return ResponseEntity.status(HttpStatus.CREATED).body(
                ApiResponse.<LoanResponse>builder()
                        .data(loanResponse)
                        .build()
        );
    }


    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<LoanResponse>> getLoan(@PathVariable("id") int id) throws AppException {
        Loan loan = loanService.findById(id);
        if (loan == null) {
            throw new AppException(Errorcode.LOAN_NOT_EXITS);
        }
        return ResponseEntity.ok(ApiResponse.<LoanResponse>builder()
                .data(loanMapper.loanToLoanResponse(loan))
                .build());
    }
}
