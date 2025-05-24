package com.techzen.academy_n0325c1.controller;

import com.techzen.academy_n0325c1.dto.JsonResponse;
import com.techzen.academy_n0325c1.dto.giaodich.GiaoDichSearchRequest;
import com.techzen.academy_n0325c1.exception.AppException;
import com.techzen.academy_n0325c1.exception.Errorcode;
import com.techzen.academy_n0325c1.model.GiaoDich;
import com.techzen.academy_n0325c1.repository.IGiaoDichRepository;
import com.techzen.academy_n0325c1.service.IGiaoDichService;
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
@RequestMapping("/giaodichs")
public class GiaoDichController {
    IGiaoDichService giaoDichService;

    @GetMapping
    public ResponseEntity<?> getByAttributes(GiaoDichSearchRequest giaoDichSearchRequest,
                                             @PageableDefault(size = 20, sort = {"id"},
                                                     direction = Sort.Direction.ASC) Pageable pageable) {
        return JsonResponse.ok(giaoDichService.findByAttributes(giaoDichSearchRequest, pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Integer id) throws AppException {
        return giaoDichService.findById(id) // Filtering: Lọc các phần tử thỏa mãn điều kiện.
                .map(JsonResponse::ok)
                .orElseThrow(() -> new AppException(Errorcode.GIAO_DICH_NOT_EXITS));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody GiaoDich giaoDich) {
        return JsonResponse.created(giaoDichService.save(giaoDich));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody GiaoDich giaoDich) throws AppException {
        giaoDichService.findById(id).orElseThrow(() -> new AppException(Errorcode.GIAO_DICH_NOT_EXITS));

        giaoDich.setId(giaoDich.getId());
        return JsonResponse.ok(giaoDichService.save(giaoDich));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) throws AppException {
        giaoDichService.findById(id).orElseThrow(() -> new AppException(Errorcode.GIAO_DICH_NOT_EXITS));
        giaoDichService.delete(id);
        return JsonResponse.noContent();
    }

}
