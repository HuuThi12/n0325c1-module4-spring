package com.techzen.academy_n0325c1.Bai9.service;

import com.techzen.academy_n0325c1.Bai9.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

public interface IStudentService {
    List<Student> finAll();

    Student save(Student student);

    Student findById(int id);

    Page<Student> findByAttr(String fullName, LocalDate fromDob, LocalDate toDob, Pageable pageable);

}
