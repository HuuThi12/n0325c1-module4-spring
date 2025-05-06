package com.techzen.academy_n0325c1.ExerciseDay3.repository;

import com.techzen.academy_n0325c1.ExerciseDay3.dto.derpartment.DepartmentSearchRequest;
import com.techzen.academy_n0325c1.ExerciseDay3.dto.employee.EmployeeSearchRequest;
import com.techzen.academy_n0325c1.ExerciseDay3.model.Department;
import com.techzen.academy_n0325c1.ExerciseDay3.model.Employee;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IDepartmentRepository {
    List<Department> findByAttributes(DepartmentSearchRequest departmentSearchRequest);

    Optional<Department> findById(Integer id);

    Department save(Department department);

    void delete(UUID id);
}
