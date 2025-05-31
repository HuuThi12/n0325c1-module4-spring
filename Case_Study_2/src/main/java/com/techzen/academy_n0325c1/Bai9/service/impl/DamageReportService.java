package com.techzen.academy_n0325c1.Bai9.service.impl;

import com.techzen.academy_n0325c1.Bai9.model.DamageReport;
import com.techzen.academy_n0325c1.Bai9.repository.IDamageReportRepository;
import com.techzen.academy_n0325c1.Bai9.service.IDamageReportService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DamageReportService implements IDamageReportService {
    IDamageReportRepository damageReportRepository;
    @Override
    public List<DamageReport> finAll() {
        return damageReportRepository.findAll();
    }

    @Override
    public DamageReport save(DamageReport damageReport) {
        return damageReportRepository.save(damageReport);
    }

    @Override
    public DamageReport findById(int id) {
       return damageReportRepository.findById(id).orElse(null);
    }

    @Override
    public Page<DamageReport> findByAttr(LocalDate reportDate, String description, Pageable pageable) {
        return damageReportRepository.findByAttr(reportDate, description, pageable);
    }


}
