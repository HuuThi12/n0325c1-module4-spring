package com.techzen.academy_n0325c1.Bai9.controller;

import com.techzen.academy_n0325c1.Bai9.dto.JsonResponse;
import com.techzen.academy_n0325c1.Bai9.dto.employee.EmployeeSearchRequest;
import com.techzen.academy_n0325c1.Bai9.exception.AppExepciton;
import com.techzen.academy_n0325c1.Bai9.exception.Errorcode;
import com.techzen.academy_n0325c1.Bai9.model.Employee;
import com.techzen.academy_n0325c1.Bai9.service.IEmployeeService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/employees")
public class EmployeeController {

        IEmployeeService employeeService;

    @GetMapping
    public ResponseEntity<?> getByAttributes(EmployeeSearchRequest employeeSearchRequest,
                                    @PageableDefault(size = 20, sort = {"id"},
                                        direction = Sort.Direction.ASC) Pageable pageable) {
        return JsonResponse.ok(employeeService.findByAttributes(employeeSearchRequest, pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") UUID id) throws AppExepciton {
        return employeeService.findById(id) // Filtering: Lọc các phần tử thỏa mãn điều kiện.
                .map(JsonResponse::ok)
                .orElseThrow(() -> new AppExepciton(Errorcode.EMPLOYEE_NOT_EXIST));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Employee employee) {
        return JsonResponse.created(employeeService.save(employee));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") UUID id, @RequestBody Employee employee) throws AppExepciton {
        employeeService.findById(id).orElseThrow(() -> new AppExepciton(Errorcode.EMPLOYEE_NOT_EXIST));

        employee.setId(employee.getId());
        return JsonResponse.ok(employeeService.save(employee));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") UUID id) throws AppExepciton {
        employeeService.findById(id).orElseThrow(() -> new AppExepciton(Errorcode.EMPLOYEE_NOT_EXIST));
        employeeService.delete(id);
        return JsonResponse.noContent();
    }
}
