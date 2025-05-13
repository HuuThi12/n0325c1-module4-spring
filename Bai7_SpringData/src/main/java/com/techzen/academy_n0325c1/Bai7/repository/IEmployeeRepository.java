package com.techzen.academy_n0325c1.Bai7.repository;

import com.techzen.academy_n0325c1.Bai7.enums.Gender;
import com.techzen.academy_n0325c1.Bai7.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.UUID;

public interface IEmployeeRepository extends JpaRepository<Employee, UUID> {
    @Query(value = """
    SELECT e.* FROM employee e
    LEFT JOIN department d ON e.department_id = d.id
    WHERE (:name IS NULL OR e.name LIKE CONCAT('%', :name, '%'))
    AND (:dobFrom IS NULL OR e.dob >= :dobFrom)
    AND (:dobTo IS NULL OR e.dob <= :dobTo)
    AND (:gender IS NULL OR e.gender = :gender)
    AND (:phone IS NULL OR e.phone LIKE CONCAT('%', :phone, '%'))
    AND (:departmentId IS NULL OR d.id = :departmentId)
    AND (
        CASE
            WHEN :salaryRange = 'lt5' THEN e.salary < 500000
            WHEN :salaryRange = '5-10' THEN e.salary BETWEEN 500000 AND 1000000
            WHEN :salaryRange = '10-20' THEN e.salary BETWEEN 1000000 AND 2000000
            WHEN :salaryRange = 'gt20' THEN e.salary > 2000000
            ELSE TRUE
        END
    )
""", nativeQuery = true)
    Page<Employee> findByAttributes(
    @Param("name") String name,
    @Param("dobFrom") LocalDate dobFrom,
    @Param("dobTo") LocalDate dobTo,
    @Param("gender") Gender gender,
    @Param("salaryRange") String salaryRange,
    @Param("phone") String phone,
    @Param("departmentId") Integer departmentId,
    Pageable pageable);

}
