package com.techzen.academy_n0325c1.Bai9.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;


@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;

    private String fullName;
    private String email;
    private String phone;
    private LocalDate dob;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "card_id", unique = true)
    private Card card;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Loan> loans;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<DamageReport> damageReports;
}