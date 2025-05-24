package com.techzen.academy_n0325c1.service;

import com.techzen.academy_n0325c1.dto.khachhang.KhachHangSearchRequest;
import com.techzen.academy_n0325c1.model.KhachHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


public interface IKhachHangService {
    Page<KhachHang> findByAttributes(KhachHangSearchRequest khachHangSearchRequest, Pageable pageable);

    Optional<KhachHang> findById(Integer id);

    KhachHang save(KhachHang khachHang);

    void delete(Integer id);
}
