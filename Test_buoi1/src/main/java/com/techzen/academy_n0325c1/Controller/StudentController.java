package com.techzen.academy_n0325c1.Controller;

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
    public ResponseEntity<List<Student>> getStudents() {
//        return ResponseEntity.status(HttpStatus.OK).body(student);
        return ResponseEntity.ok(students);
    }

    @PostMapping
    public ResponseEntity<Student> save(@RequestBody Student student) {
        student.setId((int) (Math.random() * 10000));
        students.add(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable("id") int id) {
        for (Student student : students) {
            if (student.getId() == id){
                return ResponseEntity.ok(student);
            }
        }
        return ResponseEntity.notFound().build();
    }




}
