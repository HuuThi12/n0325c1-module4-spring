package com.techzen.academy_n0325c1.Bai9.dto.penalty;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PenaltyResponse {
    Integer penaltyId;
    Integer loanId;
    Integer daysOverdue;
    Double amount;
}