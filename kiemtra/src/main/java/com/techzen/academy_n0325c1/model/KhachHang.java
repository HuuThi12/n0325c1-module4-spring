package com.techzen.academy_n0325c1.model;

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
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String tenKhachHang;
    String soDienThoai;
    String email;

    @OneToMany(mappedBy = "khachHang")
    @JsonManagedReference
    List<GiaoDich> giaoDichs;

}
