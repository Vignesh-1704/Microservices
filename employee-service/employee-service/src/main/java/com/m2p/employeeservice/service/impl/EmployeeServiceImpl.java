package com.m2p.employeeservice.service.impl;

import com.m2p.employeeservice.dto.EmployeeDto;
import com.m2p.employeeservice.entity.Employee;
import com.m2p.employeeservice.mapping.EmployeeMapper;
import com.m2p.employeeservice.repository.EmployeeRepository;
import com.m2p.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.MAPPER.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.MAPPER.maptoEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(Long.valueOf(employeeId)).get();
        return EmployeeMapper.MAPPER.maptoEmployeeDto(employee);
    }
}
