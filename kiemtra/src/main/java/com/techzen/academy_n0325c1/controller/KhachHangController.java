package com.techzen.academy_n0325c1.controller;

import com.techzen.academy_n0325c1.dto.JsonResponse;
import com.techzen.academy_n0325c1.dto.khachhang.KhachHangSearchRequest;
import com.techzen.academy_n0325c1.exception.AppException;
import com.techzen.academy_n0325c1.exception.Errorcode;
import com.techzen.academy_n0325c1.model.KhachHang;
import com.techzen.academy_n0325c1.service.impl.KhachHangService;
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
@RequestMapping("/khachhangs")
public class KhachHangController {
    KhachHangService khachHangService;


    @GetMapping
    public ResponseEntity<?> getAll(KhachHangSearchRequest khachHangSearchRequest,
                                    @PageableDefault(size = 20, sort = {"id"},
                                            direction = Sort.Direction.ASC) Pageable pageable) {
        return JsonResponse.ok(khachHangService.findByAttributes(khachHangSearchRequest, pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        return khachHangService.findById(id)
                .map(JsonResponse::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody KhachHang khachHang) {
        return JsonResponse.created(khachHangService.save(khachHang));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id,@RequestBody KhachHang khachHang) throws AppException {
        khachHangService.findById(id).orElseThrow(() -> new AppException(Errorcode.KHACH_HANG_NOT_EXITS));
        khachHang.setId(id);
        return JsonResponse.ok(khachHangService.save(khachHang));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) throws AppException {
        khachHangService.findById(id).orElseThrow(() -> new AppException(Errorcode.KHACH_HANG_NOT_EXITS));
        khachHangService.delete(id);
        return JsonResponse.noContent();
    }
}
