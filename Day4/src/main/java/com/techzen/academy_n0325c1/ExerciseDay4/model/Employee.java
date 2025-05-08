package com.techzen.academy_n0325c1.ExerciseDay4.model;

import com.techzen.academy_n0325c1.ExerciseDay4.enums.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

