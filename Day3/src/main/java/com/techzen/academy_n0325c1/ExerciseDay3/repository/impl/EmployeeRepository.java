package com.techzen.academy_n0325c1.ExerciseDay3.repository.impl;

import com.techzen.academy_n0325c1.ExerciseDay3.dto.employee.EmployeeSearchRequest;
import com.techzen.academy_n0325c1.ExerciseDay3.enums.Gender;
import com.techzen.academy_n0325c1.ExerciseDay3.model.Employee;
import com.techzen.academy_n0325c1.ExerciseDay3.repository.IEmployeeRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Repository
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmployeeRepository implements IEmployeeRepository {
    List<Employee> employees = new ArrayList<>(
            Arrays.asList(
                    new Employee(UUID.randomUUID(), "Hoàng Văn Hải", LocalDate.of(1990, 1, 15),
                            Gender.MALE, 15000000.00, "0975123542", 1),
                    new Employee(UUID.randomUUID(), "Trần Thị Hoài", LocalDate.of(1985, 5, 20),
                            Gender.FEMALE, 14500000.00, "096786968", 2),
                    new Employee(UUID.randomUUID(), "Lê Văn Sỹ", LocalDate.of(1992, 3, 10),
                            Gender.MALE, 15500000.00, "0988881110", 3),
                    new Employee(UUID.randomUUID(), "Phạm Duy Khánh", LocalDate.of(1988, 7, 5),
                            Gender.FEMALE, 14800000.00, "0986555333", 4),
                    new Employee(UUID.randomUUID(), "Hoàng Văn Hải", LocalDate.of(1995, 9, 25),
                            Gender.MALE, 15200000.00, "0973388668", 4)
            )
    );


    public List<Employee> findByAttributes(EmployeeSearchRequest employeeSearchRequest) {
        return employees.stream()
                .filter(e -> (employeeSearchRequest.getName() == null
                        || e.getName().toLowerCase()
                        .contains(employeeSearchRequest.getName().toLowerCase())))
                .collect(Collectors.toList());
//         List<Employee> employeeList = new ArrayList<>();
//        try {
//            String query = "SELECT id, name, dob, gender, salary, phone, department_id" +
//                    "FROM employee where 1=1";
//            List<Object> parameters = new ArrayList<>();
//            if (employeeSearchRequest.getName() != null) {
//                query += " AND LOWER(name) LIKE ?";
//                parameters.add("%" + employeeSearchRequest.getName().toLowerCase() + "%");
//            }
//
//            if (employeeSearchRequest.getGender() != null) {
//                query += " AND LOWER(gender) LIKE ?";
//                parameters.add("%" + employeeSearchRequest.getGender() + "%");
//            }
//            if (employeeSearchRequest.getPhone() != null) {
//                query += " AND LOWER(phone) LIKE ?";
//                parameters.add("%" + employeeSearchRequest.getPhone() + "%");
//            }
//
//            if (employeeSearchRequest.getDepartmentID() != null) {
//                query += " AND LOWER(gender) LIKE ?";
//                parameters.add("%" + employeeSearchRequest.getDepartmentID() + "%");
//            }
//
//        }
    }

    public Optional<Employee> findById(UUID id) {
        return employees.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst();
    }

    public Employee save(Employee employee) {
        return findById(employee.getId())
                .map(e -> {
                    e.setName(employee.getName());
                    e.setDOB(employee.getDOB());
                    e.setGender(employee.getGender());
                    e.setSalary(employee.getSalary());
                    e.setPhone(employee.getPhone());
                    e.setDepartmentId(employee.getDepartmentId());
                    return e;
                })
                .orElseGet(() -> {
                    employee.setId(UUID.randomUUID());
                    employees.add(employee);
                    return employee;
                });
    }

    public void delete(UUID id) {
        findById(id).ifPresent(employees::remove);
    }
}
