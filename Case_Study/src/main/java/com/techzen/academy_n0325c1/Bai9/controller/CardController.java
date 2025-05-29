package com.techzen.academy_n0325c1.Bai9.controller;

import com.techzen.academy_n0325c1.Bai9.dto.ApiResponse;
import com.techzen.academy_n0325c1.Bai9.dto.card.CardRequest;
import com.techzen.academy_n0325c1.Bai9.dto.card.CardResponse;
import com.techzen.academy_n0325c1.Bai9.mapper.ICardMapper;
import com.techzen.academy_n0325c1.Bai9.model.Card;
import com.techzen.academy_n0325c1.Bai9.service.ICardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cards")
@RequiredArgsConstructor
public class CardController {
    private final ICardService cardService;
    private final ICardMapper cardMapper;

    @PostMapping
    public ResponseEntity<?> createCard(@Valid @RequestBody CardRequest cardRequest) {
        Card card = cardMapper.cardRequestToCard(cardRequest);
        card = cardService.save(card);
        CardResponse response = cardMapper.cardToCardResponse(card);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                ApiResponse.<CardResponse>builder().data(response).message("Tạo sách thành công").build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCard(@PathVariable int id) {
        Card card = cardService.findById(id);
        if (card == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không tìm thấy sách");
        }
        return ResponseEntity.ok(
                ApiResponse.<CardResponse>builder()
                        .data(cardMapper.cardToCardResponse(card))
                        .build()
        );
    }

    @GetMapping
    public ResponseEntity<?> getCards() {
        return ResponseEntity.ok(cardService.finAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCard(@PathVariable int id, @Valid @RequestBody CardRequest cardRequest) {
        Card card = cardService.findById(id);
        if (card == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không tìm thấy sách để cập nhật");
        }
        card.setCardId(id);
        card = cardService.save(card);
        CardResponse response = cardMapper.cardToCardResponse(card);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCard(@PathVariable int id) {
        Card card = cardService.findById(id);
        if (card == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không tìm thấy sách để cập nhật");
        }
        cardService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
