package com.techzen.academy_n0325c1.Bai9.service.impl;

import com.techzen.academy_n0325c1.Bai9.model.Penalty;
import com.techzen.academy_n0325c1.Bai9.repository.IPenaltyRepository;
import com.techzen.academy_n0325c1.Bai9.service.IPenaltyService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PenaltyService implements IPenaltyService {
    IPenaltyRepository penaltyRepository;
    @Override
    public List<Penalty> finAll() {
        return penaltyRepository.findAll();
    }

    @Override
    public Penalty save(Penalty penalty) {
        return penaltyRepository.save(penalty);
    }

    @Override
    public Penalty findById(int id) {
        return penaltyRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Penalty> findByAttr(Integer daysOverdue, Double amount, Pageable pageable) {
        return penaltyRepository.findByAttr(daysOverdue, amount, pageable);
    }


}
