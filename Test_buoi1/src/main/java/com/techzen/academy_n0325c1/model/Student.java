package com.techzen.academy_n0325c1.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;



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
    private Integer id;
    private String name;
    private double score;
    private String adress;

    @OneToOne
    StudentProfile studentProfile;

    @JsonIgnoreProperties("students")
    @ManyToOne
    Clazz clazz;
}
