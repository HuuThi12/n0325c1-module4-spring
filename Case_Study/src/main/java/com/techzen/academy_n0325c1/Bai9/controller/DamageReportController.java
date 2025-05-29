package com.techzen.academy_n0325c1.Bai9.controller;

import com.techzen.academy_n0325c1.Bai9.dto.ApiResponse;
import com.techzen.academy_n0325c1.Bai9.dto.damagereport.DamageReportRequest;
import com.techzen.academy_n0325c1.Bai9.dto.damagereport.DamageReportResponse;
import com.techzen.academy_n0325c1.Bai9.dto.penalty.PenaltyRequest;
import com.techzen.academy_n0325c1.Bai9.mapper.IDamageReportMapper;
import com.techzen.academy_n0325c1.Bai9.model.DamageReport;
import com.techzen.academy_n0325c1.Bai9.service.IDamageReportService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/damagereports")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DamageReportController {
    IDamageReportService damageReportService;
    IDamageReportMapper damageReportMapper;

    @PostMapping
    public ResponseEntity<?> createDamageReport(@Valid @RequestBody DamageReportRequest damageReportRequest) {
        DamageReport damageReport = damageReportMapper.damageReportRequestToDamageReport(damageReportRequest);
        damageReport = damageReportService.save(damageReport);
        DamageReportResponse damageReportResponse = damageReportMapper.damageReportToDamageReportResponse(damageReport);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                ApiResponse.<DamageReportResponse>builder()
                        .data(damageReportResponse).message("Tạo damage report thành công")
                        .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDamageReport(@PathVariable int id) {
        DamageReport damageReport = damageReportService.findById(id);
        if (damageReport == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không tìm thấy damage Report");
        }
        return ResponseEntity.ok(
                ApiResponse.<DamageReportResponse>builder()
                        .data(damageReportMapper.damageReportToDamageReportResponse(damageReport))
                        .build()
        );
    }

    @GetMapping
    public ResponseEntity<?> getDamageReports() {
        return ResponseEntity.ok(damageReportService.finAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateDamageReport(@PathVariable int id, @Valid @RequestBody PenaltyRequest penaltyRequest) {
        DamageReport damageReport = damageReportService.findById(id);
        if (damageReport == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không tìm thấy Damage Report");
        }
        damageReport.setReportId(id);
        damageReport = damageReportService.save(damageReport);
        DamageReportResponse damageReportResponse = damageReportMapper.damageReportToDamageReportResponse(damageReport);
        return ResponseEntity.status(HttpStatus.OK).body(damageReportResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePenalty(@PathVariable int id) {
        DamageReport damageReport = damageReportService.findById(id);
        if (damageReport == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Không tìm thấy Damage Report để xóa");
        }
        damageReportService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
