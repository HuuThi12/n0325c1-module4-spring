package com.techzen.academy_n0325c1.ExerciseDay4.repository;

import com.techzen.academy_n0325c1.ExerciseDay4.dto.derpartment.DepartmentSearchRequest;
import com.techzen.academy_n0325c1.ExerciseDay4.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IDepartmentRepository extends JpaRepository<Department, Integer> {

}
