package com.techzen.academy_n0325c1.Bai9.controller;


import com.techzen.academy_n0325c1.Bai9.dto.ApiResponse;
import com.techzen.academy_n0325c1.Bai9.dto.book.BookRequest;
import com.techzen.academy_n0325c1.Bai9.dto.loan.LoanRequest;
import com.techzen.academy_n0325c1.Bai9.dto.loan.LoanResponse;
import com.techzen.academy_n0325c1.Bai9.mapper.ILoanMapper;
import com.techzen.academy_n0325c1.Bai9.model.Loan;
import com.techzen.academy_n0325c1.Bai9.service.ILoanService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loans")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class LoanController {
    ILoanService loanService;
    ILoanMapper loanMapper;

    @PostMapping
    public ResponseEntity<?> createLoan(@Valid @RequestBody LoanRequest loanRequest) {
        Loan loan = loanMapper.loanRequestToLoan(loanRequest);
        loan = loanService.save(loan);
        LoanResponse response = loanMapper.loanToLoanResponse(loan);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                ApiResponse.<LoanResponse>builder().data(response).message("Tạo sách thành công").build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getLoan(@PathVariable int id) {
        Loan loan = loanService.findById(id);
        if (loan == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không tìm thấy Loan");
        }
        return ResponseEntity.ok(
                ApiResponse.<LoanResponse>builder()
                        .data(loanMapper.loanToLoanResponse(loan))
                        .build()
        );
    }

    @GetMapping
    public ResponseEntity<?> getLoans() {
        return ResponseEntity.ok(loanService.finAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateLoan(@PathVariable int id, @Valid @RequestBody BookRequest bookRequest) {
        Loan loan = loanService.findById(id);
        if (loan == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không tìm thấy Loan");
        }
        loan.setLoanId(id);
        loan = loanService.save(loan);
        LoanResponse response = loanMapper.loanToLoanResponse(loan);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLoan(@PathVariable int id) {
        Loan loan = loanService.findById(id);
        if (loan == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không tìm thấy Loan để cập nhật");
        }
        loanService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
