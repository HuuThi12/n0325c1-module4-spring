package com.techzen.academy_n0325c1.Bai9.service.impl;

import com.techzen.academy_n0325c1.Bai9.model.DamageReport;
import com.techzen.academy_n0325c1.Bai9.repository.IDamageReportRepository;
import com.techzen.academy_n0325c1.Bai9.service.IDamageReportService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

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
    public void deleteById(int id) {
        damageReportRepository.deleteById(id);
    }
}
