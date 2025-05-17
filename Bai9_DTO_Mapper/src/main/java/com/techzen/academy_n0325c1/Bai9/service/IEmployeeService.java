package com.techzen.academy_n0325c1.Bai9.service;

import com.techzen.academy_n0325c1.Bai9.dto.employee.EmployeeSearchRequest;
import com.techzen.academy_n0325c1.Bai9.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface IEmployeeService {
     Page<Employee> findByAttributes(EmployeeSearchRequest employeeSearchRequest, Pageable pageable);

     Optional<Employee> findById(UUID id);

     Employee save(Employee employee);

     void delete(UUID id);
}
