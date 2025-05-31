package com.techzen.academy_n0325c1.Bai9.repository;

import com.techzen.academy_n0325c1.Bai9.model.Penalty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IPenaltyRepository extends JpaRepository<Penalty, Integer> {
    @Query(value = """
    SELECT l.* 
    FROM loan l
    JOIN penalty p ON l.loan_id = p.loan_id
    WHERE (:daysOverdue IS NULL OR p.days_overdue = :daysOverdue)
      AND (:amount IS NULL OR p.amount = :amount)
    """, nativeQuery = true)
    Page<Penalty> findByAttr(@Param("daysOverdue") Integer daysOverdue,
                          @Param("amount") Double amount,
                          Pageable pageable);

}