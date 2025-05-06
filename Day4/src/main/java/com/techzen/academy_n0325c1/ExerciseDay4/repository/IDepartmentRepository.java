package com.techzen.academy_n0325c1.ExerciseDay4.repository;

import com.techzen.academy_n0325c1.ExerciseDay4.dto.derpartment.DepartmentSearchRequest;
import com.techzen.academy_n0325c1.ExerciseDay4.model.Department;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IDepartmentRepository {
    List<Department> findByAttributes(DepartmentSearchRequest departmentSearchRequest);

    Optional<Department> findById(Integer id);

    Department save(Department department);

    void delete(UUID id);
}
