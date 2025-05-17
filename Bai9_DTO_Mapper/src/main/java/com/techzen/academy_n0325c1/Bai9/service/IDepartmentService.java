package com.techzen.academy_n0325c1.Bai9.service;

import com.techzen.academy_n0325c1.Bai9.dto.derpartment.DepartmentSearchRequest;
import com.techzen.academy_n0325c1.Bai9.model.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IDepartmentService {
    Page<Department> findByAttributes(DepartmentSearchRequest departmentSearchRequest, Pageable pageable);

    Optional<Department> findById(Integer id);

    Department save(Department department);

    void delete(Integer id);
}
