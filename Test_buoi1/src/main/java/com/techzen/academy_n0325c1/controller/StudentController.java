package com.techzen.academy_n0325c1.controller;

import com.techzen.academy_n0325c1.dto.ApiResponse;
import com.techzen.academy_n0325c1.exception.AppException;
import com.techzen.academy_n0325c1.exception.Errorcode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private List<Student> students = new ArrayList<>(
            Arrays.asList(
                    new Student(1, "thi", 9),
                    new Student(2, "Ngọc", 8),
                    new Student(3, "Sơn", 7)
            )
    );

    @GetMapping
    public ResponseEntity<ApiResponse<List<Student>>> getStudents() {
//        return ResponseEntity.status(HttpStatus.OK).body(student);
        return ResponseEntity.ok(ApiResponse.<List<Student>>builder()
                .data(students)
                .build());
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Student>> save(@RequestBody Student student) {
        student.setId((int) (Math.random() * 10000));
        students.add(student);
        return ResponseEntity.ok(ApiResponse.<Student>builder()
                .data(student)
                .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Student>> getStudent(@PathVariable("id") int id) throws AppException {
        for (Student student : students) {
            if (student.getId() == id) {
//                return ResponseEntity.ok(new ApiResponse<Student>(student));
//                dùng ApiResponse.builder để khi có nhiều constructor sẽ giúp đở truyền tham số
                return ResponseEntity.ok(ApiResponse.<Student>builder()
                                .data(student)
                        .build());
            }
        };

        throw new AppException(Errorcode.STUDENT_NOT_EXITS);

        // Không nên viết code ỏ đây vì đây là trường hợp hiếm (ngoại lệ)
//        return ResponseEntity.status(Errorcode.STUDENT_NOT_EXITS.getStatus()).body(
//                ApiResponse.<Student>builder()
//                        .code(Errorcode.STUDENT_NOT_EXITS.getCode())
//                        .message(Errorcode.STUDENT_NOT_EXITS.getMessage())
//                        .build()
//        );
    }


}
