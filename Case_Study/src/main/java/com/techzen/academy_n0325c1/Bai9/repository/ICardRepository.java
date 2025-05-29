package com.techzen.academy_n0325c1.Bai9.repository;

import com.techzen.academy_n0325c1.Bai9.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICardRepository extends JpaRepository<Card, Integer> {
}