package com.techzen.academy_n0325c1.Bai9.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;


@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class QuanLy {
    @Id
    private String maQL;
    private String hoTen;
    private String chucVu;

    @OneToMany(mappedBy = "capBoi")
    private List<TheThuVien> theThuViens;
}