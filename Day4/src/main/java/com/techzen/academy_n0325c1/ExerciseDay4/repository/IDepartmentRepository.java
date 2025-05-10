package com.techzen.academy_n0325c1.ExerciseDay4.repository;

import com.techzen.academy_n0325c1.ExerciseDay4.dto.derpartment.DepartmentSearchRequest;
import com.techzen.academy_n0325c1.ExerciseDay4.model.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IDepartmentRepository extends JpaRepository<Department, Integer> {
    @Query(value = """
         select * from department where name like concat('%', :name, '%')   
    """, nativeQuery = true)
    Page<Department> findByAttributes(
            @Param("name") String name,
            Pageable pageable);
}
