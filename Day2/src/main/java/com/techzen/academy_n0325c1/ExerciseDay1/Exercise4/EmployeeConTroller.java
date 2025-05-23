package com.techzen.academy_n0325c1.ExerciseDay1.Exercise4;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/employee")
public class EmployeeConTroller {
    private final List<Employee> employees = new ArrayList<>(
            Arrays.asList(
                    new Employee(UUID.randomUUID(), "Hoàng Văn Hải", LocalDate.of( 1990,  1, 15),
                            Employee.Gender.MALE,  15000000.00),
                    new Employee(UUID.randomUUID(), "Trần Thị Hoài", LocalDate.of( 1985,  5, 20),
                            Employee.Gender.FEMALE,  14500000.00),
                    new Employee(UUID.randomUUID(), "Lê Văn Sỹ", LocalDate.of( 1992,  3, 10),
                            Employee.Gender.MALE,  15500000.00),
                    new Employee(UUID.randomUUID(), "Phạm Duy Khánh", LocalDate.of( 1988,  7, 5),
                            Employee.Gender.FEMALE,  14800000.00),
                    new Employee(UUID.randomUUID(), "Hoàng Văn Hải", LocalDate.of( 1995,  9, 25),
                            Employee.Gender.MALE,  15200000.00)
            )
    );

    @GetMapping
    public ResponseEntity<List<Employee>> getAll() {
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getById(@PathVariable("id") UUID id) {
        return employees.stream() // Filtering: Lọc các phần tử thỏa mãn điều kiện.
                // filter: lọc phần tử
                .filter(e -> e.getId().equals(id))
                .findFirst()
                // map(Function) → Biến đổi phần tử
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        employee.setId(UUID.randomUUID());
        employees.add(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(employee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> update(@PathVariable("id") UUID id, @RequestBody Employee employee) {
        return employees.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .map(e -> {
                    e.setName(employee.getName());
                    e.setDOB(employee.getDOB());
                    e.setGender(employee.getGender());
                    e.setSalary(employee.getSalary());
                    return ResponseEntity.ok(e);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") UUID id) {
        return employees.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .map(s ->{
                    employees.remove(s);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

}
