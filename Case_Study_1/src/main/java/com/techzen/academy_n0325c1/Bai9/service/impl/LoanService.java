package com.techzen.academy_n0325c1.Bai9.service.impl;

import com.techzen.academy_n0325c1.Bai9.model.Loan;
import com.techzen.academy_n0325c1.Bai9.repository.ILoanRepository;
import com.techzen.academy_n0325c1.Bai9.service.ILoanService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class LoanService implements ILoanService {

    ILoanRepository loanRepository;
    @Override
    public List<Loan> finAll() {
        return loanRepository.findAll();
    }

    @Override
    public Loan save(Loan loan) {
        return loanRepository.save(loan);
    }

    @Override
    public Loan findById(int id) {
        return loanRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Loan> findByAttr(LocalDate borrowDate, LocalDate dueDate, LocalDate returnDate, Pageable pageable) {
        return loanRepository.findByAttr(borrowDate, dueDate, returnDate, pageable);
    }


}
