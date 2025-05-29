package com.techzen.academy_n0325c1.Bai9.controller;

import com.techzen.academy_n0325c1.Bai9.dto.ApiResponse;
import com.techzen.academy_n0325c1.Bai9.dto.penalty.PenaltyRequest;
import com.techzen.academy_n0325c1.Bai9.dto.penalty.PenaltyResponse;
import com.techzen.academy_n0325c1.Bai9.dto.student.StudentRequest;
import com.techzen.academy_n0325c1.Bai9.dto.student.StudentResponse;
import com.techzen.academy_n0325c1.Bai9.mapper.IPenaltyMapper;
import com.techzen.academy_n0325c1.Bai9.model.Penalty;
import com.techzen.academy_n0325c1.Bai9.model.Student;
import com.techzen.academy_n0325c1.Bai9.service.IPenaltyService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/penaltys")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PenaltyController {
    IPenaltyService penaltyService;
    IPenaltyMapper penaltyMapper;

    @PostMapping
    public ResponseEntity<?> createPenalty(@Valid @RequestBody PenaltyRequest penaltyRequest) {
        Penalty penalty = penaltyMapper.penaltyRequestToPenalty(penaltyRequest);
        penalty = penaltyService.save(penalty);
        PenaltyResponse penaltyResponse = penaltyMapper.penaltyToPenaltyResponse(penalty);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                ApiResponse.<PenaltyResponse>builder()
                        .data(penaltyResponse).message("Tạo penalty thành công")
                        .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPenalty(@PathVariable int id) {
        Penalty penalty = penaltyService.findById(id);
        if (penalty == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không tìm thấy penalty");
        }
        return ResponseEntity.ok(
                ApiResponse.<PenaltyResponse>builder()
                        .data(penaltyMapper.penaltyToPenaltyResponse(penalty))
                        .build()
        );
    }

    @GetMapping
    public ResponseEntity<?> getAllPenalties() {
        return ResponseEntity.ok(penaltyService.finAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePenalty(@PathVariable int id, @Valid @RequestBody PenaltyRequest penaltyRequest) {
        Penalty penalty = penaltyService.findById(id);
        if (penalty == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không tìm thấy penalty");
        }
        penalty.setPenaltyId(id);
        penalty = penaltyService.save(penalty);
        PenaltyResponse penaltyResponse = penaltyMapper.penaltyToPenaltyResponse(penalty);
        return ResponseEntity.status(HttpStatus.OK).body(penaltyResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePenalty(@PathVariable int id) {
        Penalty penalty = penaltyService.findById(id);
        if (penalty == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Không tìm thấy penalty để cập nhật");
        }
        penaltyService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
