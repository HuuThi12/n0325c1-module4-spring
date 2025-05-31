package com.techzen.academy_n0325c1.Bai9.mapper;


import com.techzen.academy_n0325c1.Bai9.dto.admin.AdminRequest;
import com.techzen.academy_n0325c1.Bai9.dto.admin.AdminResponse;
import com.techzen.academy_n0325c1.Bai9.model.Admin;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface IAdminMapper {
    Admin adminRequestToAdmin(AdminRequest adminRequest);
    AdminResponse adminToAdminResponse(Admin admin);

}