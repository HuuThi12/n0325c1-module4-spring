package com.techzen.academy_n0325c1.Bai7.service.impl;

import com.techzen.academy_n0325c1.Bai7.dto.employee.EmployeeSearchRequest;
import com.techzen.academy_n0325c1.Bai7.model.Employee;
import com.techzen.academy_n0325c1.Bai7.repository.IEmployeeRepository;
import com.techzen.academy_n0325c1.Bai7.service.IEmployeeService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmployeeService implements IEmployeeService {
    IEmployeeRepository employeeRepository ;

    @Override
    public Page<Employee> findByAttributes(EmployeeSearchRequest employeeSearchRequest, Pageable pageable){
        return employeeRepository.findByAttributes(employeeSearchRequest.getName(),
                employeeSearchRequest.getDobFrom(),
                employeeSearchRequest.getDobTo(),
                employeeSearchRequest.getGender(),
                employeeSearchRequest.getSalaryRange(),
                employeeSearchRequest.getPhone(),
                employeeSearchRequest.getDepartmentId(),
                pageable
                );
    }



    @Override
    public Optional<Employee> findById(UUID id){
        return employeeRepository.findById(id);
    }

    @Override
    public Employee save(Employee employee){
        return employeeRepository.save(employee);
    }

    @Override
    public void delete(UUID id){
        employeeRepository.deleteById(id);
    }
}
