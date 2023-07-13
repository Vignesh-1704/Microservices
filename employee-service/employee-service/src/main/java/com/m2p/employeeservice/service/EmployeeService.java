package com.m2p.employeeservice.service;

import com.m2p.employeeservice.dto.APIResponseDto;
import com.m2p.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    APIResponseDto getEmployeeById(Long employeeId);
}
