package com.techzen.academy_n0325c1.Bai9.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;

    private String title;
    private String author;
    private Integer totalCopies;
    private Integer availableCopies;


    @OneToMany(mappedBy = "book")
    @JsonIgnoreProperties("book")
    List<Loan> loans;

//    @JsonIgnoreProperties("book")
//    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
//    private List<DamageReport> damageReports;
}