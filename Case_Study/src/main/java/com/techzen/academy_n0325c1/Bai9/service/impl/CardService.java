package com.techzen.academy_n0325c1.Bai9.service.impl;

import com.techzen.academy_n0325c1.Bai9.model.Card;
import com.techzen.academy_n0325c1.Bai9.repository.ICardRepository;
import com.techzen.academy_n0325c1.Bai9.service.ICardService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CardService implements ICardService {

    ICardRepository cardRepository;

    @Override
    public List<Card> finAll() {
        return cardRepository.findAll();
    }

    @Override
    public Card save(Card card) {
        return cardRepository.save(card);
    }

    @Override
    public Card findById(int id) {
        return cardRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(int id) {
        cardRepository.deleteById(id);
    }
}
