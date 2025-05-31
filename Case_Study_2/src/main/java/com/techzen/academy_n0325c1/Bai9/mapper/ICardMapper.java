package com.techzen.academy_n0325c1.Bai9.mapper;

import com.techzen.academy_n0325c1.Bai9.dto.card.CardRequest;
import com.techzen.academy_n0325c1.Bai9.dto.card.CardResponse;
import com.techzen.academy_n0325c1.Bai9.model.Card;
import org.mapstruct.Mapper;
import java.util.List;



@Mapper(componentModel = "spring")
public interface ICardMapper {
    Card cardRequestToCard(CardRequest cardRequest);
    CardResponse cardToCardResponse(Card card);
}