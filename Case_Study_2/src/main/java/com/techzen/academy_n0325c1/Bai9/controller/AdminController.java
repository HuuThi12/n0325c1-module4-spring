package com.techzen.academy_n0325c1.Bai9.controller;


import com.techzen.academy_n0325c1.Bai9.dto.ApiResponse;
import com.techzen.academy_n0325c1.Bai9.dto.admin.AdminRequest;
import com.techzen.academy_n0325c1.Bai9.dto.admin.AdminResponse;
import com.techzen.academy_n0325c1.Bai9.dto.page.PageResponse;
import com.techzen.academy_n0325c1.Bai9.exception.AppException;
import com.techzen.academy_n0325c1.Bai9.exception.Errorcode;
import com.techzen.academy_n0325c1.Bai9.mapper.IAdminMapper;
import com.techzen.academy_n0325c1.Bai9.model.Admin;
import com.techzen.academy_n0325c1.Bai9.service.IAdminService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admins")
@RequiredArgsConstructor
public class AdminController {
    private final IAdminService adminService;
    private final IAdminMapper adminMapper;

    @GetMapping
    public ResponseEntity<ApiResponse<PageResponse<AdminResponse>>> getAdmins(
            @RequestParam(defaultValue = "") String fullName,
            String email, Pageable pageable) {
        return ResponseEntity.ok(ApiResponse.<PageResponse<AdminResponse>>builder()
                .data(new PageResponse<>(adminService.findByAttr(fullName, email, pageable)
                        .map(adminMapper::adminToAdminResponse)))
                .build());
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody AdminRequest adminRequest) {
        // B1: chuyển từ request sang entity
        Admin admin = adminMapper.adminRequestToAdmin(adminRequest);
        // B2: Lưu Entity xuống DB
        admin = adminService.save(admin);
        // B3: Chuyển Entity về AdminResponse
        AdminResponse adminResponse = adminMapper.adminToAdminResponse(admin);
        //B4: return về StudentResponse
        return ResponseEntity.status(HttpStatus.CREATED).body(
                ApiResponse.<AdminResponse>builder()
                        .data(adminResponse)
                        .build()
        );
    }


    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<AdminResponse>> getAdmin(@PathVariable("id") int id) throws AppException {
        Admin admin = adminService.findById(id);
        if (admin == null) {
            throw new AppException(Errorcode.ADMIN_NOT_EXITS);
        }
        return ResponseEntity.ok(ApiResponse.<AdminResponse>builder()
                .data(adminMapper.adminToAdminResponse(admin))
                .build());
    }
}
