package com.techzen.academy_n0325c1.Bai9.mapper;

import com.techzen.academy_n0325c1.Bai9.dto.admin.AdminRequest;
import com.techzen.academy_n0325c1.Bai9.dto.student.StudentRequest;
import com.techzen.academy_n0325c1.Bai9.dto.student.StudentResponse;
import com.techzen.academy_n0325c1.Bai9.model.Admin;
import com.techzen.academy_n0325c1.Bai9.model.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IStudentMapper {
    Student studentRequestToStudent(StudentRequest studentRequest);

    @Mapping(source = "card.cardId", target = "cardId")
    StudentResponse studentToStudentResponse(Student student);

}