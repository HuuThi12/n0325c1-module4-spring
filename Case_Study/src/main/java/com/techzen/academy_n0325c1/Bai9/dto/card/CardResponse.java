package com.techzen.academy_n0325c1.Bai9.dto.card;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CardResponse {
    Integer cardId;
    LocalDate issueDate;
    LocalDate expiryDate;
}
