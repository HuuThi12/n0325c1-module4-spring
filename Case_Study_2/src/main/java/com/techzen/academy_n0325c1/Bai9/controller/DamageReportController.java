package com.techzen.academy_n0325c1.Bai9.controller;

import com.techzen.academy_n0325c1.Bai9.dto.ApiResponse;
import com.techzen.academy_n0325c1.Bai9.dto.book.BookRequest;
import com.techzen.academy_n0325c1.Bai9.dto.book.BookResponse;
import com.techzen.academy_n0325c1.Bai9.dto.damagereport.DamageReportRequest;
import com.techzen.academy_n0325c1.Bai9.dto.damagereport.DamageReportResponse;
import com.techzen.academy_n0325c1.Bai9.dto.page.PageResponse;
import com.techzen.academy_n0325c1.Bai9.dto.penalty.PenaltyRequest;
import com.techzen.academy_n0325c1.Bai9.exception.AppException;
import com.techzen.academy_n0325c1.Bai9.exception.Errorcode;
import com.techzen.academy_n0325c1.Bai9.mapper.IDamageReportMapper;
import com.techzen.academy_n0325c1.Bai9.model.Book;
import com.techzen.academy_n0325c1.Bai9.model.DamageReport;
import com.techzen.academy_n0325c1.Bai9.service.IDamageReportService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/damagereports")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DamageReportController {
    IDamageReportService damageReportService;
    IDamageReportMapper damageReportMapper;

    @GetMapping
    public ResponseEntity<ApiResponse<PageResponse<DamageReportResponse>>> getDamageReports(
            @RequestParam(defaultValue = "") LocalDate reportDate,
            String description , Pageable pageable) {
        return ResponseEntity.ok(ApiResponse.<PageResponse<DamageReportResponse>>builder()
                .data(new PageResponse<>(damageReportService.findByAttr(reportDate, description, pageable)
                        .map(damageReportMapper::damageReportToDamageReportResponse)))
                .build());
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody DamageReportRequest damageReportRequest) {
        // B1: chuyển từ request sang entity
        DamageReport damageReport = damageReportMapper.damageReportRequestToDamageReport(damageReportRequest);
        // B2: Lưu Entity xuống DB
        damageReport = damageReportService.save(damageReport);
        // B3: Chuyển Entity về AdminResponse
        DamageReportResponse damageReportResponse = damageReportMapper.damageReportToDamageReportResponse(damageReport);
        //B4: return về StudentResponse
        return ResponseEntity.status(HttpStatus.CREATED).body(
                ApiResponse.<DamageReportResponse>builder()
                        .data(damageReportResponse)
                        .build()
        );
    }


    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<DamageReportResponse>> getBook(@PathVariable("id") int id) throws AppException {
        DamageReport damageReport = damageReportService.findById(id);
        if (damageReport == null) {
            throw new AppException(Errorcode.DAMAGE_REPORT_NOT_EXITS);
        }
        return ResponseEntity.ok(ApiResponse.<DamageReportResponse>builder()
                .data(damageReportMapper.damageReportToDamageReportResponse(damageReport))
                .build());
    }
}
