package com.techzen.academy_n0325c1.repository;

import com.techzen.academy_n0325c1.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IStudentRepository extends JpaRepository<Student, Integer> {
    // cách 1
    // List<Student> findByNameContainingAndScoreBetween(String name, double fromScore, double toScore);

//    cách 2
//    @Query("""
//            FROM Student WHERE name LIKE concat('%', :name, '%')
//            AND(:fromScore IS NULL OR  score >= :fromScore)
//            AND(:toScore IS NULL OR score <= :toScore)
//            """)
//    List<Student> findByAttr(String name, Double fromScore, Double toScore);

    @Query(value = """
            select * from student where name like concat('%', :name, '%') 
            AND(:fromScore IS NULL OR  score >= :fromScore) 
            AND(:toScore IS NULL OR score <= :toScore)
            """, nativeQuery = true) // -> dùng cấu trúc mysql có thể viết hoa hoặc thường
    List<Student> findByAttr(String name, Double fromScore, Double toScore);
}
