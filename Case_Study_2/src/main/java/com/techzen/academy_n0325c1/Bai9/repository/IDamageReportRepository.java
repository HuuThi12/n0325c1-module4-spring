package com.techzen.academy_n0325c1.Bai9.repository;

import com.techzen.academy_n0325c1.Bai9.model.DamageReport;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface IDamageReportRepository extends JpaRepository<DamageReport, Integer> {
    @Query(value = """
            select * from damage_report
            where (:reportDate IS NULL OR report_date = :reportDate)
            AND (:description IS NULL OR description like concat('%', :description, '%'))
            """, nativeQuery = true)
    Page<DamageReport> findByAttr(@Param("reportDate") LocalDate reportDate,
                                  @Param("description") String description,
                                  Pageable pageable);

}