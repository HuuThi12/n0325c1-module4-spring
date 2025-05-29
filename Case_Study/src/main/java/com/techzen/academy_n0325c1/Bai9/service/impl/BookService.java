package com.techzen.academy_n0325c1.Bai9.service.impl;

import com.techzen.academy_n0325c1.Bai9.dto.book.BookRequest;
import com.techzen.academy_n0325c1.Bai9.dto.book.BookResponse;
import com.techzen.academy_n0325c1.Bai9.mapper.IBookMapper;
import com.techzen.academy_n0325c1.Bai9.model.Book;
import com.techzen.academy_n0325c1.Bai9.repository.IBookRepository;
import com.techzen.academy_n0325c1.Bai9.service.IBookService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BookService implements IBookService {

    IBookRepository bookRepository;

    @Override
    public List<Book> finAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book findById(int id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(int id) {
        bookRepository.deleteById(id);
    }
}
