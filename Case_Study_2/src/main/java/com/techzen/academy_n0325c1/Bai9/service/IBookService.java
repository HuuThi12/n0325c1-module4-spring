package com.techzen.academy_n0325c1.Bai9.service;

import com.techzen.academy_n0325c1.Bai9.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBookService {
    List<Book> finAll();

    Book save(Book book) ;

    Book findById(int id);

    Page<Book> findByAttr(String title, String author, Integer totalCopies, Pageable pageable);
}
