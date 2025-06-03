package com.techzen.academy_n0325c1.Bai9.dto.admin;

import com.techzen.academy_n0325c1.Bai9.dto.book.BookRequest;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AdminRequest {
    Integer adminId;
    BookRequest book;
    String fullName;
    String email;
}