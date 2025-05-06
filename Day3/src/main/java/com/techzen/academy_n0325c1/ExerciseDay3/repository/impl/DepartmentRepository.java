package com.techzen.academy_n0325c1.ExerciseDay3.repository.impl;

import com.techzen.academy_n0325c1.ExerciseDay3.dto.derpartment.DepartmentSearchRequest;
import com.techzen.academy_n0325c1.ExerciseDay3.model.Department;
import com.techzen.academy_n0325c1.ExerciseDay3.repository.IDepartmentRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DepartmentRepository implements IDepartmentRepository {
    private final List<Department> departments = new ArrayList<>(
            Arrays.asList(
                    new Department(1, "Quản lý"),
                    new Department(2, "Kế Toán"),
                    new Department(3, "Sale-Marketing"),
                    new Department(4, "Sản xuất")
            )
    );

    public List<Department> findByAttributes(DepartmentSearchRequest departmentSearchRequest) {
        return departments.stream()
                .filter(e -> (departmentSearchRequest.getName() == null
                        || e.getName().toLowerCase()
                        .contains(departmentSearchRequest.getName().toLowerCase())))
                .collect(Collectors.toList());
    }

    public Optional<Department> findById(Integer id) {
        return departments.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst();
    }

    public Department save(Department department) {
        return findById(department.getId())
                .map(e -> {
                    e.setName(department.getName());
                    return e;
                })
                .orElseGet(() -> {
                    // ở đây chua dc
                    department.setId(department.getId());
                    departments.add(department);
                    return department;
                });
    }

    @Override
    public void delete(UUID id) {
    }

    public void delete(Integer id) {
        findById(id).ifPresent(departments::remove);
    }
}
