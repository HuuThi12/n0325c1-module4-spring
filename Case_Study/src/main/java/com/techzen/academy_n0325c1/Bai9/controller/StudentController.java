package com.techzen.academy_n0325c1.Bai9.controller;


import com.techzen.academy_n0325c1.Bai9.dto.ApiResponse;
import com.techzen.academy_n0325c1.Bai9.dto.student.StudentRequest;
import com.techzen.academy_n0325c1.Bai9.dto.student.StudentResponse;
import com.techzen.academy_n0325c1.Bai9.mapper.IStudentMapper;
import com.techzen.academy_n0325c1.Bai9.model.Student;
import com.techzen.academy_n0325c1.Bai9.service.IStudentService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StudentController {
    IStudentService studentService;
    IStudentMapper studentMapper;

    @PostMapping
    public ResponseEntity<?> createStudent(@Valid @RequestBody StudentRequest studentRequest) {
        Student student = studentMapper.studentRequestToStudent(studentRequest);
        student = studentService.save(student);
        StudentResponse studentResponse = studentMapper.studentToStudentResponse(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                ApiResponse.<StudentResponse>builder().data(studentResponse).message("Tạo sinh viên thành công").build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudent(@PathVariable int id) {
        Student student = studentService.findById(id);
        if (student == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không tìm thấy Student");
        }
        return ResponseEntity.ok(
                ApiResponse.<StudentResponse>builder()
                        .data(studentMapper.studentToStudentResponse(student))
                        .build()
        );
    }

    @GetMapping
    public ResponseEntity<?> getAllStudents() {
        return ResponseEntity.ok(studentService.finAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable int id, @Valid @RequestBody StudentRequest studentRequest) {
        Student student = studentService.findById(id);
        if (student == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không tìm thấy Student");
        }
        student.setStudentId(id);
        student = studentService.save(student);
        StudentResponse studentResponse = studentMapper.studentToStudentResponse(student);
        return ResponseEntity.status(HttpStatus.OK).body(studentResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable int id) {
        Student student = studentService.findById(id);
        if (student == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Không tìm thấy sinh viên để cập nhật");
        }
        studentService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
