package com.techzen.academy_n0325c1.controller;

import com.techzen.academy_n0325c1.dto.ApiResponse;
import com.techzen.academy_n0325c1.dto.clazz.ClazzResponse;
import com.techzen.academy_n0325c1.dto.page.PageResponse;
import com.techzen.academy_n0325c1.dto.student.StudentRequest;
import com.techzen.academy_n0325c1.dto.student.StudentResponse;
import com.techzen.academy_n0325c1.exception.AppException;
import com.techzen.academy_n0325c1.exception.Errorcode;
import com.techzen.academy_n0325c1.mapper.IStudentMapper;
import com.techzen.academy_n0325c1.model.Clazz;
import com.techzen.academy_n0325c1.model.Student;
import com.techzen.academy_n0325c1.service.IStudentService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StudentController {

    private final IStudentService studentService; // DI thông qua Constructor

    IStudentMapper studentMapper;

    @GetMapping
    public ResponseEntity<ApiResponse<PageResponse<StudentResponse>>> getStudents(
            @RequestParam(defaultValue = "") String name,
            Double fromScore, Double toScore, Pageable pageable) {
        return ResponseEntity.ok(ApiResponse.<PageResponse<StudentResponse>>builder()
                .data(new PageResponse<>(studentService.findByAttr(name, fromScore, toScore, pageable)
                        .map(studentMapper::studentToStudentResponse)))
                .build());
    }

    @PostMapping
    public ResponseEntity<ApiResponse<StudentResponse>> save(@RequestBody StudentRequest studentRequest) {
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
    public ResponseEntity<ApiResponse<Student>> getStudent(@PathVariable("id") int id) throws AppException {
        Student student = studentService.findById(id);
        if (student == null) {
            throw new AppException(Errorcode.STUDENT_NOT_EXITS);
        }
        return ResponseEntity.ok(ApiResponse.<Student>builder()
                .data(student)
                .build());
    }
};



