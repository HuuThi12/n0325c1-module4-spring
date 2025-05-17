package com.techzen.academy_n0325c1.Bai9.service.impl;

import com.techzen.academy_n0325c1.Bai9.dto.derpartment.DepartmentSearchRequest;
import com.techzen.academy_n0325c1.Bai9.model.Department;
import com.techzen.academy_n0325c1.Bai9.repository.IDepartmentRepository;
import com.techzen.academy_n0325c1.Bai9.service.IDepartmentService;
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
public class DepartmentService implements IDepartmentService {

    IDepartmentRepository departmentRepository;

    @Override
    public Page<Department> findByAttributes(DepartmentSearchRequest departmentSearchRequest, Pageable pageable) {
        return departmentRepository.findByAttributes(departmentSearchRequest.getName(),
                pageable
        );
    }

    @Override
    public Optional<Department> findById(Integer id) {
        return departmentRepository.findById(id);
    }

    @Override
    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public void delete(Integer id) {
        departmentRepository.deleteById(id);
    }
}
