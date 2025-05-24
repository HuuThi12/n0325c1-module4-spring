package com.techzen.academy_n0325c1.repository;

import com.techzen.academy_n0325c1.model.KhachHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IKhachHangRepository extends JpaRepository<KhachHang, Integer> {
    @Query(value = """
            SELECT * FROM khach_hang kh WHERE ten_khach_hang LIKE CONCAT('%', :ten_khach_hang, '%'))
                   AND (:soDienThoai IS NULL OR kh.so_dien_thoai = :soDienThoai)
                   AND (:email IS NULL OR kh.email = :email)
            """,
            nativeQuery = true)



    Page<KhachHang> findByAttributes(
            @Param("tenKhachHang") String tenKhachHang,
            @Param("soDienThoai") String soDienThoai,
            @Param("email") String email,
            Pageable pageable
    );
}
