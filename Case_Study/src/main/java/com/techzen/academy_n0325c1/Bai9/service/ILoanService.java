package com.techzen.academy_n0325c1.Bai9.service;

import com.techzen.academy_n0325c1.Bai9.model.Card;
import com.techzen.academy_n0325c1.Bai9.model.Loan;

import java.util.List;

public interface ILoanService {
    List<Loan> finAll();

    Loan save(Loan loan) ;

    Loan findById(int id);

    void deleteById(int id);
}
