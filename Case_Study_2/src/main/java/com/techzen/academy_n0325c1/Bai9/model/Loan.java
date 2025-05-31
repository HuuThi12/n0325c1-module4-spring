package com.techzen.academy_n0325c1.Bai9.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer loanId;
    LocalDate borrowDate;
    LocalDate dueDate;
    LocalDate returnDate;
    String status;

    @ManyToOne
    Book book;

//    @ManyToOne
//    @JoinColumn(name = "student_id")
//    private Student student;
//



     // "BORROWED" or "RETURNED"

//    @OneToMany(mappedBy = "loan", cascade = CascadeType.ALL)
//    private List<Penalty> penalties;
}