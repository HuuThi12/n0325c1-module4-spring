package com.techzen.academy_n0325c1.Bai9.service;

import com.techzen.academy_n0325c1.Bai9.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> finAll();

    Book save(Book book) ;

    Book findById(int id);

    void deleteById(int id);
}
