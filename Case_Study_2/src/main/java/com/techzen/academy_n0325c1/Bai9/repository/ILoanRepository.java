package com.techzen.academy_n0325c1.Bai9.repository;

import com.techzen.academy_n0325c1.Bai9.model.Loan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ILoanRepository extends JpaRepository<Loan, Integer> {
    @Query(value = """
            select * from loan 
            where (:borrowDate IS NULL OR borrow_date = :borrowDate)
            AND (:dueDate IS NULL OR due_date = :dueDate)
            AND (:returnDate IS NULL OR return_date = :returnDate)
            """, nativeQuery = true)
    Page<Loan> findByAttr(@Param("borrowDate") LocalDate borrowDate,
                          @Param("dueDate") LocalDate dueDate,
                          @Param("returnDate") LocalDate returnDate,
                          Pageable pageable);

}