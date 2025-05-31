package com.techzen.academy_n0325c1.Bai9.service;

import com.techzen.academy_n0325c1.Bai9.model.DamageReport;
import com.techzen.academy_n0325c1.Bai9.model.Loan;

import java.util.List;

public interface IDamageReportService {
    List<DamageReport> finAll();

    DamageReport save(DamageReport damageReport) ;

    DamageReport findById(int id);

    void deleteById(int id);
}
