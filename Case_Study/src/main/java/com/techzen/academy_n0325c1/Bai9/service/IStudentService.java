package com.techzen.academy_n0325c1.Bai9.service;

import com.techzen.academy_n0325c1.Bai9.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> finAll();

    Student save(Student student) ;

    Student findById(int id);

    void deleteById(int id);
}
