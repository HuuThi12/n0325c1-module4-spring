package com.techzen.academy_n0325c1.Bai9.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;


@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;

    @OneToMany(mappedBy = "department")
    @JsonManagedReference
    // JsonManagedReference thuộc tính cha trong mối quan hệ 2 chiều
    List<Employee> employees;
}
