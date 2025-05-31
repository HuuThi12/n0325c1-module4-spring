package com.techzen.academy_n0325c1.Bai9.mapper;

import com.techzen.academy_n0325c1.Bai9.dto.damagereport.DamageReportRequest;
import com.techzen.academy_n0325c1.Bai9.dto.damagereport.DamageReportResponse;
import com.techzen.academy_n0325c1.Bai9.model.DamageReport;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring")
public interface IDamageReportMapper {
    @Mapping(source = "studentId", target = "student.studentId")
    @Mapping(source = "bookId", target = "book.bookId")
    DamageReport damageReportRequestToDamageReport(DamageReportRequest damageReportRequest);

    @Mapping(source = "student.studentId", target = "studentId")
    @Mapping(source = "book.bookId", target = "bookId")
    DamageReportResponse damageReportToDamageReportResponse(DamageReport damageReport);

}