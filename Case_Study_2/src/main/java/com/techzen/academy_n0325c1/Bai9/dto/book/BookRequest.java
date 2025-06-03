package com.techzen.academy_n0325c1.Bai9.dto.book;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookRequest {
    Integer bookId;

    @NotBlank(message = "Tiêu đề không được để trống")
    String title;

    @NotBlank(message = "Tác giả không được để trống")
    String author;

    @NotNull(message = "Tổng số bản sao là bắt buộc")
    @Min(value = 1, message = "Tổng số bản sao phải lớn hơn 0")
    Integer totalCopies;

    @NotNull(message = "Số bản sao khả dụng là bắt buộc")
    @Min(value = 0, message = "Số bản sao khả dụng không được âm")
    Integer availableCopies;
}