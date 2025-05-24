package com.techzen.academy_n0325c1.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GiaoDich {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String loaiDichVu;
    LocalDate ngayGiaoDich;
    Double donGia;
    Double dienTich;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "khachhang_id")
    @JsonBackReference
    KhachHang khachHang;
}
