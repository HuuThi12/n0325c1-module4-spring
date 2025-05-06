package com.techzen.academy_n0325c1.ExerciseDay4.repository;

import com.techzen.academy_n0325c1.ExerciseDay4.dto.employee.EmployeeSearchRequest;
import com.techzen.academy_n0325c1.ExerciseDay4.model.Employee;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IEmployeeRepository {
    List<Employee> findByAttributes(EmployeeSearchRequest employeeSearchRequest);

    Optional<Employee> findById(UUID id);

    Employee save(Employee employee);

    void delete(UUID id);
}
