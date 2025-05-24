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
public class TheThuVien {
    @Id
    private String maThe;
    private Date ngayCap;
    private int phiDuyTri;
    private boolean hopLe;

    @OneToOne
    private SinhVien sinhVien;

    @ManyToOne
    private QuanLy capBoi;
}
