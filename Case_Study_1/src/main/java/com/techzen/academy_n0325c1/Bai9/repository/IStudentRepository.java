package com.techzen.academy_n0325c1.Bai9.repository;

import com.techzen.academy_n0325c1.Bai9.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Integer> {
    @Query(value = """
            select * from student 
            where full_name like concat('%', :fullName, '%')
            AND (:fromDob IS NULL OR dob >= :fromDob)
            AND (:toDob IS NULL OR dob <= :toDob)
            """, nativeQuery = true)
    Page<Student> findByAttr(@Param("fullName") String fullName,
                             @Param("fromDob") LocalDate fromDob,
                             @Param("toDob") LocalDate toDob,
                             Pageable pageable);

}
