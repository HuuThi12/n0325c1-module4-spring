package com.techzen.academy_n0325c1.Bai9.model;

import lombok.*;

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
public class SinhVien {
    @Id
    private String maSV;
    private String hoTen;
    private String lop;
    private String email;

    @OneToMany(mappedBy = "sinhVien")
    private List<MuonSach> muonSachs;

    @OneToOne(mappedBy = "sinhVien")
    private TheThuVien theThuVien;

    @OneToMany(mappedBy = "sinhVien")
    private List<BaoCaoHuHong> baoCaoHuHongs;
}