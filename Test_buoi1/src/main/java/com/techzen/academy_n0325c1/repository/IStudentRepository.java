package com.techzen.academy_n0325c1.repository;

import com.techzen.academy_n0325c1.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IStudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByNameContaining(String name);
}
