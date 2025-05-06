package com.techzen.academy_n0325c1.ExerciseDay3.service.impl;

import com.techzen.academy_n0325c1.ExerciseDay3.dto.derpartment.DepartmentSearchRequest;
import com.techzen.academy_n0325c1.ExerciseDay3.model.Department;
import com.techzen.academy_n0325c1.ExerciseDay3.repository.IDepartmentRepository;
import com.techzen.academy_n0325c1.ExerciseDay3.service.IDepartmentService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DepartmentService implements IDepartmentService {

    IDepartmentRepository departmentRepository;

    @Override
    public List<Department> findByAttributes(DepartmentSearchRequest departmentSearchRequest){
        return departmentRepository.findByAttributes(departmentSearchRequest);
    }

    @Override
    public Optional<Department> findById(Integer id){
        return departmentRepository.findById(id);
    }

    @Override
    public Department save(Department department){
        return departmentRepository.save(department);
    }

    @Override
    public void delete(Integer id){
        departmentRepository.delete(UUID.randomUUID());
    }
}
