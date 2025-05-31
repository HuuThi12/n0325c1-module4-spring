package com.techzen.academy_n0325c1.Bai9.mapper;

import com.techzen.academy_n0325c1.Bai9.dto.book.BookRequest;
import com.techzen.academy_n0325c1.Bai9.dto.book.BookResponse;
import com.techzen.academy_n0325c1.Bai9.model.Book;
import org.mapstruct.Mapper;
import java.util.List;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IBookMapper {
    Book bookRequestToBook(BookRequest bookRequest);
    BookResponse bookToBookResponse(Book book);
}