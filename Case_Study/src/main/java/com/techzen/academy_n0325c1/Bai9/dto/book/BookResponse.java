package com.techzen.academy_n0325c1.Bai9.dto.book;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookResponse {
    Integer bookId;
    String title;
    String author;
    Integer totalCopies;
    Integer availableCopies;
}