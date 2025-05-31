package com.techzen.academy_n0325c1.Bai9.controller;

import com.techzen.academy_n0325c1.Bai9.dto.ApiResponse;
import com.techzen.academy_n0325c1.Bai9.dto.admin.AdminRequest;
import com.techzen.academy_n0325c1.Bai9.dto.admin.AdminResponse;
import com.techzen.academy_n0325c1.Bai9.dto.card.CardRequest;
import com.techzen.academy_n0325c1.Bai9.dto.card.CardResponse;
import com.techzen.academy_n0325c1.Bai9.dto.page.PageResponse;
import com.techzen.academy_n0325c1.Bai9.exception.AppException;
import com.techzen.academy_n0325c1.Bai9.exception.Errorcode;
import com.techzen.academy_n0325c1.Bai9.mapper.ICardMapper;
import com.techzen.academy_n0325c1.Bai9.model.Admin;
import com.techzen.academy_n0325c1.Bai9.model.Card;
import com.techzen.academy_n0325c1.Bai9.service.ICardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/cards")
@RequiredArgsConstructor
public class CardController {
    private final ICardService cardService;
    private final ICardMapper cardMapper;

    @GetMapping
    public ResponseEntity<ApiResponse<PageResponse<CardResponse>>> getAdmins(
            @RequestParam(defaultValue = "") LocalDate issueDate,
            LocalDate expiryDate, Pageable pageable) {
        return ResponseEntity.ok(ApiResponse.<PageResponse<CardResponse>>builder()
                .data(new PageResponse<>(cardService.findByAttr(issueDate, expiryDate, pageable)
                        .map(cardMapper::cardToCardResponse)))
                .build());
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody CardRequest cardRequest) {
        // B1: chuyển từ request sang entity
        Card card = cardMapper.cardRequestToCard(cardRequest);
        // B2: Lưu Entity xuống DB
        card = cardService.save(card);
        // B3: Chuyển Entity về AdminResponse
        CardResponse cardResponse = cardMapper.cardToCardResponse(card);
        //B4: return về StudentResponse
        return ResponseEntity.status(HttpStatus.CREATED).body(
                ApiResponse.<CardResponse>builder()
                        .data(cardResponse)
                        .build()
        );
    }


    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CardResponse>> getAdmin(@PathVariable("id") int id) throws AppException {
        Card card = cardService.findById(id);
        if (card == null) {
            throw new AppException(Errorcode.CARD_NOT_EXITS);
        }
        return ResponseEntity.ok(ApiResponse.<CardResponse>builder()
                .data(cardMapper.cardToCardResponse(card))
                .build());
    }

}
