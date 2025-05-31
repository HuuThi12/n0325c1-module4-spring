package com.techzen.academy_n0325c1.Bai9.service;

import com.techzen.academy_n0325c1.Bai9.model.Book;
import com.techzen.academy_n0325c1.Bai9.model.Card;
import com.techzen.academy_n0325c1.Bai9.model.Loan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

public interface ILoanService {
    List<Loan> finAll();

    Loan save(Loan loan) ;

    Loan findById(int id);

    Page<Loan> findByAttr(LocalDate borrowDate, LocalDate dueDate, LocalDate returnDate, Pageable pageable);
}
