package com.techzen.academy_n0325c1.Bai9.repository;

import com.techzen.academy_n0325c1.Bai9.model.Penalty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPenaltyRepository extends JpaRepository<Penalty, Integer> {
}