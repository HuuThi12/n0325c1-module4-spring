package com.techzen.academy_n0325c1.Bai9.controller;


import com.techzen.academy_n0325c1.Bai9.dto.ApiResponse;
import com.techzen.academy_n0325c1.Bai9.dto.admin.AdminRequest;
import com.techzen.academy_n0325c1.Bai9.dto.admin.AdminResponse;
import com.techzen.academy_n0325c1.Bai9.mapper.IAdminMapper;
import com.techzen.academy_n0325c1.Bai9.model.Admin;
import com.techzen.academy_n0325c1.Bai9.service.IAdminService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admins")
@RequiredArgsConstructor
public class AdminController {
    private final IAdminService adminService;
    private final IAdminMapper adminMapper;

    @PostMapping
    public ResponseEntity<?> createAdmin(@Valid @RequestBody AdminRequest adminRequest) {
        Admin admin = adminMapper.adminRequestToAdmin(adminRequest);
        admin = adminService.save(admin);
        AdminResponse response = adminMapper.adminToAdminResponse(admin);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                ApiResponse.<AdminResponse>builder().data(response).message("Tạo sách thành công").build()
        );
    }

    @GetMapping
    public ResponseEntity<?> getAdmin(){
        return  ResponseEntity.ok(adminService.finAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAdmin(@PathVariable int id) {
        Admin admin  = adminService.findById(id);
        if (admin == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không tìm thấy admin");
        }
        return ResponseEntity.ok(
                ApiResponse.<AdminResponse>builder()
                        .data(adminMapper.adminToAdminResponse(admin))
                        .build()
        );
    }



    @PutMapping("/{id}")
    public ResponseEntity<?> updateAdmin(@PathVariable int id, @Valid @RequestBody AdminRequest request) {
        Admin admin  = adminService.findById(id);
        if (admin == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không tìm thấy admin");
        }
        admin.setAdminId(id);
        admin = adminService.save(admin);
        AdminResponse response = adminMapper.adminToAdminResponse(admin);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAdmin(@PathVariable int id) {
        Admin admin  = adminService.findById(id);
        if (admin == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không tìm thấy sách để cập nhật");
        }
        adminService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
