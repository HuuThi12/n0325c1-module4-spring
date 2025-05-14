package com.techzen.academy_n0325c1.Bai8.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.techzen.academy_n0325c1.Bai8.enums.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;


import java.math.BigDecimal;
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
    @Column(columnDefinition = "ENUM ('MALE','FEMALE'")
    @Enumerated(EnumType.STRING)
    Gender gender;
    BigDecimal salary;
    String phone;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id")
    @JsonBackReference
    Department department;
}

