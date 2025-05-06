package com.techzen.academy_n0325c1.ExerciseDay3.dto.employee;

import com.techzen.academy_n0325c1.ExerciseDay3.enums.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeSearchRequest {
    String name;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    LocalDate dobFrom;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    LocalDate dobTo;

    Gender gender;
    String salaryRange;
    String phone;
    String departmentID;


}
