package com.techzen.academy_n0325c1.Bai9.repository;

import com.techzen.academy_n0325c1.Bai9.model.Card;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ICardRepository extends JpaRepository<Card, Integer> {
    @Query(value = """
            select * from card 
            where (:issueDate IS NULL OR issue_date = :issueDate)
            AND (:expiryDate IS NULL OR expiry_date = :expiryDate)
            """, nativeQuery = true)
    Page<Card> findByAttr(@Param("issueDate") LocalDate issueDate,
                          @Param("expiryDate") LocalDate expiryDate,
                          Pageable pageable);

}