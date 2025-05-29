package com.techzen.academy_n0325c1.Bai9.service.impl;

import com.techzen.academy_n0325c1.Bai9.model.Student;
import com.techzen.academy_n0325c1.Bai9.repository.IStudentRepository;
import com.techzen.academy_n0325c1.Bai9.service.IStudentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StudentService implements IStudentService {
     IStudentRepository studentRepository;

    @Override
    public List<Student> finAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student findById(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(int id) {
        studentRepository.deleteById(id);
    }
}
