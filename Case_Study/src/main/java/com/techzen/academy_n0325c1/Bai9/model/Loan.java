package com.techzen.academy_n0325c1.Bai9.model;

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
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer loanId;

//    @ManyToOne
//    @JoinColumn(name = "student_id")
//    private Student student;
//
//    @ManyToOne
//    @JoinColumn(name = "book_id")
//    private Book book;

    private LocalDate borrowDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private String status; // "BORROWED" or "RETURNED"

//    @OneToMany(mappedBy = "loan", cascade = CascadeType.ALL)
//    private List<Penalty> penalties;
}