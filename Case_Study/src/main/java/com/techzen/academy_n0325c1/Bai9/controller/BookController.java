package com.techzen.academy_n0325c1.Bai9.controller;

import com.techzen.academy_n0325c1.Bai9.dto.ApiResponse;
import com.techzen.academy_n0325c1.Bai9.dto.book.BookRequest;
import com.techzen.academy_n0325c1.Bai9.dto.book.BookResponse;
import com.techzen.academy_n0325c1.Bai9.mapper.IBookMapper;
import com.techzen.academy_n0325c1.Bai9.model.Book;
import com.techzen.academy_n0325c1.Bai9.service.IBookService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BookController {
    IBookService bookService;
    IBookMapper bookMapper;

    @PostMapping
    public ResponseEntity<?> createBook(@Valid @RequestBody BookRequest bookRequest) {
        Book book = bookMapper.bookRequestToBook(bookRequest);
        book = bookService.save(book);
        BookResponse response = bookMapper.bookToBookResponse(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                ApiResponse.<BookResponse>builder().data(response).message("Tạo sách thành công").build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBook(@PathVariable int id) {
        Book book = bookService.findById(id);
        if (book == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không tìm thấy sách");
        }
        return ResponseEntity.ok(
                ApiResponse.<BookResponse>builder()
                        .data(bookMapper.bookToBookResponse(book))
                        .build()
        );
    }

    @GetMapping
    public ResponseEntity<?> getBooks() {
        return ResponseEntity.ok(bookService.finAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBook(@PathVariable int id, @Valid @RequestBody BookRequest bookRequest) {
        Book book = bookService.findById(id);
        if (book == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không tìm thấy sách để cập nhật");
        }
        book.setBookId(id);
        book = bookService.save(book);
        BookResponse response = bookMapper.bookToBookResponse(book);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable int id) {
        Book book = bookService.findById(id);
        if (book == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không tìm thấy sách để cập nhật");
        }
        bookService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}