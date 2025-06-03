package com.techzen.academy_n0325c1.Bai9.service;

import com.techzen.academy_n0325c1.Bai9.model.DamageReport;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

public interface IDamageReportService {
    List<DamageReport> finAll();

    DamageReport save(DamageReport damageReport) ;

    DamageReport findById(int id);

    Page<DamageReport> findByAttr(LocalDate reportDate, String description, Pageable pageable);
}
