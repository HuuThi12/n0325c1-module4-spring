package com.techzen.academy_n0325c1.Bai9.service.impl;

import com.techzen.academy_n0325c1.Bai9.model.Admin;
import com.techzen.academy_n0325c1.Bai9.repository.IAdminRepository;
import com.techzen.academy_n0325c1.Bai9.service.IAdminService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AdmindService implements IAdminService {

    IAdminRepository adminRepository;
    @Override
    public List<Admin> finAll() {
        return adminRepository.findAll();
    }

    @Override
    public Admin save(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public Admin findById(int id) {
        return adminRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Admin> findByAttr(String fullName, String email, Pageable pageable) {
        return adminRepository.findByAttr(fullName, email, pageable);
    }


}
