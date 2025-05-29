package com.techzen.academy_n0325c1.Bai9.service;

import com.techzen.academy_n0325c1.Bai9.model.Book;
import com.techzen.academy_n0325c1.Bai9.model.Card;

import java.util.List;

public interface ICardService {
    List<Card> finAll();

    Card save(Card card) ;

    Card findById(int id);

    void deleteById(int id);
}
