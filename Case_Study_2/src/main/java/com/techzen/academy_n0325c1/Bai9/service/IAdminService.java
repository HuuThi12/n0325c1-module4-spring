package com.techzen.academy_n0325c1.Bai9.service;

import com.techzen.academy_n0325c1.Bai9.model.Admin;
import com.techzen.academy_n0325c1.Bai9.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

public interface IAdminService {
    List<Admin> finAll();

    Admin save(Admin admin);

    Admin findById(int id);

    Page<Admin> findByAttr(String fullName, String email, Pageable pageable);
}
