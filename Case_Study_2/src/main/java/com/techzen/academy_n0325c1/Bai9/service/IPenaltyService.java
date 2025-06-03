package com.techzen.academy_n0325c1.Bai9.service;


import com.techzen.academy_n0325c1.Bai9.model.Penalty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPenaltyService {
    List<Penalty> finAll();

    Penalty save(Penalty penalty) ;

    Penalty findById(int id);

    Page<Penalty> findByAttr(Integer daysOverdue, Double amount, Pageable pageable);
}
