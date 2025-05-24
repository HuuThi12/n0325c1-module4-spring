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
public class Sach {
    @Id
    private String maSach;
    private String tenSach;
    private String tacGia;
    private int soLuong;
    private String theLoai;
    private String tinhTrang;

    @OneToMany(mappedBy = "sach")
    private List<MuonSach> muonSachs;

    @OneToMany(mappedBy = "sach")
    private List<BaoCaoHuHong> baoCaoHuHongs;
}

