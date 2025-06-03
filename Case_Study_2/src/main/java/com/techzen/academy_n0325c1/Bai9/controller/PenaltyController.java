package com.techzen.academy_n0325c1.Bai9.controller;

import com.techzen.academy_n0325c1.Bai9.dto.ApiResponse;
import com.techzen.academy_n0325c1.Bai9.dto.page.PageResponse;
import com.techzen.academy_n0325c1.Bai9.dto.penalty.PenaltyRequest;
import com.techzen.academy_n0325c1.Bai9.dto.penalty.PenaltyResponse;
import com.techzen.academy_n0325c1.Bai9.exception.AppException;
import com.techzen.academy_n0325c1.Bai9.exception.Errorcode;
import com.techzen.academy_n0325c1.Bai9.mapper.IPenaltyMapper;
import com.techzen.academy_n0325c1.Bai9.model.Penalty;
import com.techzen.academy_n0325c1.Bai9.service.IPenaltyService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/penalties")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PenaltyController {
    IPenaltyService penaltyService;
    IPenaltyMapper penaltyMapper;

    @GetMapping
    public ResponseEntity<ApiResponse<PageResponse<PenaltyResponse>>> getPenalties(
            @RequestParam(defaultValue = "") Integer daysOverdue,
            Double amount, Pageable pageable) {
        return ResponseEntity.ok(ApiResponse.<PageResponse<PenaltyResponse>>builder()
                .data(new PageResponse<>(penaltyService.findByAttr(daysOverdue, amount, pageable)
                        .map(penaltyMapper::penaltyToPenaltyResponse)))
                .build());
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody PenaltyRequest penaltyRequest) {
        // B1: chuyển từ request sang entity
        Penalty penalty = penaltyMapper.penaltyRequestToPenalty(penaltyRequest);
        // B2: Lưu Entity xuống DB
        penalty = penaltyService.save(penalty);
        // B3: Chuyển Entity về AdminResponse
        PenaltyResponse penaltyResponse = penaltyMapper.penaltyToPenaltyResponse(penalty);
        //B4: return về StudentResponse
        return ResponseEntity.status(HttpStatus.CREATED).body(
                ApiResponse.<PenaltyResponse>builder()
                        .data(penaltyResponse)
                        .build()
        );
    }


    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<PenaltyResponse>> getPenalty(@PathVariable("id") int id) throws AppException {
        Penalty penalty = penaltyService.findById(id);
        if (penalty == null) {
            throw new AppException(Errorcode.PENALTY_NOT_EXITS);
        }
        return ResponseEntity.ok(ApiResponse.<PenaltyResponse>builder()
                .data(penaltyMapper.penaltyToPenaltyResponse(penalty))
                .build());
    }

}
