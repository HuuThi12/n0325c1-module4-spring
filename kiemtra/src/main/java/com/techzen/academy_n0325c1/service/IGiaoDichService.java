package com.techzen.academy_n0325c1.service;

import com.techzen.academy_n0325c1.dto.giaodich.GiaoDichSearchRequest;
import com.techzen.academy_n0325c1.model.GiaoDich;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
public interface IGiaoDichService {
    Page<GiaoDich> findByAttributes(GiaoDichSearchRequest giaoDichSearchRequest, Pageable pageable);

    Optional<GiaoDich> findById(Integer id);

    GiaoDich save(GiaoDich giaoDich);

    void delete(Integer id);
}
