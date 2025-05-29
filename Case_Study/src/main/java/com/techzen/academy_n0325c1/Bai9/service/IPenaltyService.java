package com.techzen.academy_n0325c1.Bai9.service;


import com.techzen.academy_n0325c1.Bai9.model.Penalty;

import java.util.List;

public interface IPenaltyService {
    List<Penalty> finAll();

    Penalty save(Penalty penalty) ;

    Penalty findById(int id);

    void deleteById(int id);
}
