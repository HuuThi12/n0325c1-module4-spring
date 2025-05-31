package com.techzen.academy_n0325c1.Bai9.controller;


import com.techzen.academy_n0325c1.Bai9.dto.ApiResponse;
import com.techzen.academy_n0325c1.Bai9.dto.page.PageResponse;
import com.techzen.academy_n0325c1.Bai9.dto.student.StudentRequest;
import com.techzen.academy_n0325c1.Bai9.dto.student.StudentResponse;
import com.techzen.academy_n0325c1.Bai9.exception.AppException;
import com.techzen.academy_n0325c1.Bai9.exception.Errorcode;
import com.techzen.academy_n0325c1.Bai9.mapper.IStudentMapper;
import com.techzen.academy_n0325c1.Bai9.model.Student;
import com.techzen.academy_n0325c1.Bai9.service.IStudentService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;


@RestController
@RequestMapping("/students")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StudentController {
    IStudentService studentService;
    IStudentMapper studentMapper;

    @GetMapping
    public ResponseEntity<ApiResponse<PageResponse<StudentResponse>>> getStudents(
            @RequestParam(defaultValue = "") String fullName,
            LocalDate fromDob, LocalDate toDob, Pageable pageable) {
        return ResponseEntity.ok(ApiResponse.<PageResponse<StudentResponse>>builder()
                .data(new PageResponse<>(studentService.findByAttr(fullName, fromDob, toDob, pageable)
                        .map(studentMapper::studentToStudentResponse)))
                .build());
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody StudentRequest studentRequest) {
        // B1: chuyển từ request sang entity
        Student student = studentMapper.studentRequestToStudent(studentRequest);
        // B2: Lưu Entity xuống DB
        student = studentService.save(student);
        // B3: Chuyển Entity về StudentResponse
        StudentResponse studentResponse = studentMapper.studentToStudentResponse(student);
        //B4: return về StudentResponse
        return ResponseEntity.status(HttpStatus.CREATED).body(
                ApiResponse.<StudentResponse>builder()
                        .data(studentResponse)
                        .build()
        );
    }


    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<StudentResponse>> getStudent(@PathVariable("id") int id) throws AppException {
        Student student = studentService.findById(id);
        if (student == null) {
            throw new AppException(Errorcode.STUDENT_NOT_EXITS);
        }
        return ResponseEntity.ok(ApiResponse.<StudentResponse>builder()
                .data(studentMapper.studentToStudentResponse(student))
                .build());
    }

}



