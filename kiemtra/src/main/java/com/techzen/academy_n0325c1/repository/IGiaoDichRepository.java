package com.techzen.academy_n0325c1.repository;

import com.techzen.academy_n0325c1.model.GiaoDich;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface IGiaoDichRepository extends JpaRepository<GiaoDich, Integer> {
    @Query(value = """

            SELECT * FROM giao_dich gd
            LEFT JOIN khach_hang kh ON kh.khachhang_id = gd.id
        WHERE (:loaiDichVu IS NULL OR gd.loai_dich_vu = :loaiDichVu)
          AND (:ngayGiaoDich IS NULL OR gd.ngayGiaoDich = :ngayGiaoDich)
          AND (:donGia IS NULL OR gd.don_gia = :donGia)
          AND (:dienTich IS NULL OR gd.dien_tich = :dienTich)
        """,
            nativeQuery = true)
    Page<GiaoDich> findByAttributes(
            @Param("loaiDichVu") String loaiDichVu,
            @Param("ngayGiaoDich") Date ngayGiaoDich,
            @Param("donGia") Double donGia,
            @Param("dienTich") Double dienTich,
            Pageable pageable
    );
}