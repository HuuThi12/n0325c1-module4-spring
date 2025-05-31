package com.techzen.academy_n0325c1.Bai9.dto.damagereport;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DamageReportResponse {
    Integer reportId;
    Integer studentId;
    Integer bookId;
    LocalDate reportDate;
    String description;
}