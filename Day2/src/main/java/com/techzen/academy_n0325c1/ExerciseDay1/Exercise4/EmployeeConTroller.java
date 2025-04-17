package com.techzen.academy_n0325c1.ExerciseDay1.Exercise4;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
