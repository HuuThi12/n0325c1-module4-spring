package com.techzen.academy_n0325c1.Bai9.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;


@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MuonSach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maMuon;

    @ManyToOne
    private SinhVien sinhVien;

    @ManyToOne
    private Sach sach;

    private Date ngayMuon;
    private Date hanTra;
    private String tinhTrang;
}

