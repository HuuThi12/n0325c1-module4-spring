package com.techzen.academy_n0325c1.Bai9.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;


@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BaoCaoHuHong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maBaoCao;

    @ManyToOne
    private SinhVien sinhVien;

    @ManyToOne
    private Sach sach;

    private String moTa;
    private Date ngayBaoCao;
}