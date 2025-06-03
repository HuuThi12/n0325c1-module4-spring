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
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer adminId;

    private String fullName;
    private String email;

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private List<Book> books;

//    @OneToMany(mappedBy = "admin")
//    private List<Student> students;

}