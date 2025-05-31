package com.techzen.academy_n0325c1.Bai9.service;

import com.techzen.academy_n0325c1.Bai9.model.Admin;
import com.techzen.academy_n0325c1.Bai9.model.Book;
import com.techzen.academy_n0325c1.Bai9.model.Card;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

public interface ICardService {
    List<Card> finAll();

    Card save(Card card) ;

    Card findById(int id);

    Page<Card> findByAttr(LocalDate issueDate, LocalDate expiryDate, Pageable pageable);
}
