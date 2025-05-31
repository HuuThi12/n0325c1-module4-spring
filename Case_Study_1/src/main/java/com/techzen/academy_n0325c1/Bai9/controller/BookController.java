package com.techzen.academy_n0325c1.Bai9.controller;

import com.techzen.academy_n0325c1.Bai9.dto.ApiResponse;
import com.techzen.academy_n0325c1.Bai9.dto.admin.AdminRequest;
import com.techzen.academy_n0325c1.Bai9.dto.admin.AdminResponse;
import com.techzen.academy_n0325c1.Bai9.dto.book.BookRequest;
import com.techzen.academy_n0325c1.Bai9.dto.book.BookResponse;
import com.techzen.academy_n0325c1.Bai9.dto.page.PageResponse;
import com.techzen.academy_n0325c1.Bai9.exception.AppException;
import com.techzen.academy_n0325c1.Bai9.exception.Errorcode;
import com.techzen.academy_n0325c1.Bai9.mapper.IBookMapper;
import com.techzen.academy_n0325c1.Bai9.model.Admin;
import com.techzen.academy_n0325c1.Bai9.model.Book;
import com.techzen.academy_n0325c1.Bai9.service.IBookService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Pageable;
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

    @GetMapping
    public ResponseEntity<ApiResponse<PageResponse<BookResponse>>> getBooks(
            @RequestParam(defaultValue = "") String title,
            String author, Integer totalCopies , Pageable pageable) {
        return ResponseEntity.ok(ApiResponse.<PageResponse<BookResponse>>builder()
                .data(new PageResponse<>(bookService.findByAttr(title, author, totalCopies, pageable)
                        .map(bookMapper::bookToBookResponse)))
                .build());
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody BookRequest bookRequest) {
        // B1: chuyển từ request sang entity
        Book book = bookMapper.bookRequestToBook(bookRequest);
        // B2: Lưu Entity xuống DB
        book = bookService.save(book);
        // B3: Chuyển Entity về AdminResponse
        BookResponse bookResponse = bookMapper.bookToBookResponse(book);
        //B4: return về StudentResponse
        return ResponseEntity.status(HttpStatus.CREATED).body(
                ApiResponse.<BookResponse>builder()
                        .data(bookResponse)
                        .build()
        );
    }


    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<BookResponse>> getBook(@PathVariable("id") int id) throws AppException {
        Book book = bookService.findById(id);
        if (book == null) {
            throw new AppException(Errorcode.BOOK_NOT_EXITS);
        }
        return ResponseEntity.ok(ApiResponse.<BookResponse>builder()
                .data(bookMapper.bookToBookResponse(book))
                .build());
    }
}