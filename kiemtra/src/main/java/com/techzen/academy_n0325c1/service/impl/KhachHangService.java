package com.techzen.academy_n0325c1.service.impl;

import com.techzen.academy_n0325c1.dto.khachhang.KhachHangSearchRequest;
import com.techzen.academy_n0325c1.model.KhachHang;
import com.techzen.academy_n0325c1.repository.IKhachHangRepository;
import com.techzen.academy_n0325c1.service.IKhachHangService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class KhachHangService implements IKhachHangService {
    IKhachHangRepository khachHangRepository;

    @Override
    public Page<KhachHang> findByAttributes(KhachHangSearchRequest khachHangSearchRequest, Pageable pageable) {
        return khachHangRepository.findByAttributes(khachHangSearchRequest.getTenKhachHang(),
                khachHangSearchRequest.getSoDienThoai(),
                khachHangSearchRequest.getEmail(),
                pageable
        );
    }

    @Override
    public Optional<KhachHang> findById(Integer id) {
        return khachHangRepository.findById(id);
    }

    @Override
    public KhachHang save(KhachHang department) {
        return khachHangRepository.save(department);
    }

    @Override
    public void delete(Integer id) {
        khachHangRepository.deleteById(id);
    }
}