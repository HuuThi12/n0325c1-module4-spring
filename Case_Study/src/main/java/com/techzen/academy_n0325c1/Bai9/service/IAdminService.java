package com.techzen.academy_n0325c1.Bai9.service;

import com.techzen.academy_n0325c1.Bai9.model.Admin;

import java.util.List;

public interface IAdminService {
    List<Admin> finAll();

    Admin save(Admin admin) ;

    Admin findById(int id);

    void deleteById(int id);
}
