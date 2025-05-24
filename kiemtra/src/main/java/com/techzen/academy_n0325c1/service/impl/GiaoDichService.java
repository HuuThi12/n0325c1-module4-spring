package com.techzen.academy_n0325c1.service.impl;


import com.techzen.academy_n0325c1.dto.giaodich.GiaoDichSearchRequest;
import com.techzen.academy_n0325c1.model.GiaoDich;
import com.techzen.academy_n0325c1.repository.IGiaoDichRepository;
import com.techzen.academy_n0325c1.service.IGiaoDichService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GiaoDichService implements IGiaoDichService{
    IGiaoDichRepository giaoDichRepository ;

    @Override
    public Page<GiaoDich> findByAttributes(GiaoDichSearchRequest giaoDichSearchRequest, Pageable pageable){
        return giaoDichRepository.findByAttributes(giaoDichSearchRequest.getLoaiDichVu(),
                giaoDichSearchRequest.getNgayGiaoDich(),
                giaoDichSearchRequest.getDonGia(),
                giaoDichSearchRequest.getDienTich(),
                pageable
        );
    }



    @Override
    public Optional<GiaoDich> findById(Integer id){
        return giaoDichRepository.findById(id);
    }

    @Override
    public GiaoDich save(GiaoDich giaoDich){
        return giaoDichRepository.save(giaoDich);
    }

    @Override
    public void delete(Integer id){
        giaoDichRepository.deleteById(id);
    }
}
