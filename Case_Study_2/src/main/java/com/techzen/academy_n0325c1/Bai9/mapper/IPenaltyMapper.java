package com.techzen.academy_n0325c1.Bai9.mapper;

import com.techzen.academy_n0325c1.Bai9.dto.penalty.PenaltyRequest;
import com.techzen.academy_n0325c1.Bai9.dto.penalty.PenaltyResponse;
import com.techzen.academy_n0325c1.Bai9.model.Penalty;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring")
public interface IPenaltyMapper {
    @Mapping(source = "loanId", target = "loan.loanId")
    Penalty penaltyRequestToPenalty(PenaltyRequest penaltyRequest);

    @Mapping(source = "loan.loanId", target = "loanId")
    PenaltyResponse penaltyToPenaltyResponse(Penalty penalty);

}