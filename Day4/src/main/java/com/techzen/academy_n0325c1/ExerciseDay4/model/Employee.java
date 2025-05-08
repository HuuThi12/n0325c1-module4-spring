package com.techzen.academy_n0325c1.ExerciseDay4.model;

import com.techzen.academy_n0325c1.ExerciseDay4.enums.Gender;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;


import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Employee {
    @Id
    @GeneratedValue(generator = "UUID")
    UUID id;
    String name;
    // DOB = Date of Birth
    LocalDate DOB;
    Gender gender;
    double salary;
    String phone;
    Integer departmentId;
}

