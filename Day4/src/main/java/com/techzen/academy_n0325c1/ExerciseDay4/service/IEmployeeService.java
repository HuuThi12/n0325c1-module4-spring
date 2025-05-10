package com.techzen.academy_n0325c1.ExerciseDay4.service;

import com.techzen.academy_n0325c1.ExerciseDay4.dto.employee.EmployeeSearchRequest;
import com.techzen.academy_n0325c1.ExerciseDay4.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IEmployeeService {
     Page<Employee> findByAttributes(EmployeeSearchRequest employeeSearchRequest, Pageable pageable);

     Optional<Employee> findById(UUID id);

     Employee save(Employee employee);

     void delete(UUID id);
}
