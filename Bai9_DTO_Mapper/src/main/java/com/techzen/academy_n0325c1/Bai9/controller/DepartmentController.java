package com.techzen.academy_n0325c1.Bai9.controller;

import com.techzen.academy_n0325c1.Bai9.dto.JsonResponse;
import com.techzen.academy_n0325c1.Bai9.dto.derpartment.DepartmentSearchRequest;
import com.techzen.academy_n0325c1.Bai9.exception.AppExepciton;
import com.techzen.academy_n0325c1.Bai9.exception.Errorcode;
import com.techzen.academy_n0325c1.Bai9.model.Department;
import com.techzen.academy_n0325c1.Bai9.service.impl.DepartmentService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/departments")
public class DepartmentController {

    DepartmentService departmentService;


    @GetMapping
    public ResponseEntity<?> getAll(DepartmentSearchRequest departmentSearchRequest,
                                    @PageableDefault(size = 20, sort = {"id"},
                                            direction = Sort.Direction.ASC) Pageable pageable) {
        return JsonResponse.ok(departmentService.findByAttributes(departmentSearchRequest, pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        return departmentService.findById(id)
                .map(JsonResponse::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Department department) {
        return JsonResponse.created(departmentService.save(department));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id,@RequestBody Department department) throws AppExepciton {
        departmentService.findById(id).orElseThrow(() -> new AppExepciton(Errorcode.DEPARTMENT_NOT_EXIST));
        department.setId(id);
        return JsonResponse.ok(departmentService.save(department));
    }

   @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) throws AppExepciton {
        departmentService.findById(id).orElseThrow(() -> new AppExepciton(Errorcode.DEPARTMENT_NOT_EXIST));
        departmentService.delete(id);
        return JsonResponse.noContent();
   }

}
