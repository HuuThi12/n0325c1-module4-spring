package com.techzen.academy_n0325c1.ExerciseDay4.repository;

import com.techzen.academy_n0325c1.ExerciseDay4.dto.employee.EmployeeSearchRequest;
import com.techzen.academy_n0325c1.ExerciseDay4.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IEmployeeRepository extends JpaRepository<Employee, UUID> {

}
