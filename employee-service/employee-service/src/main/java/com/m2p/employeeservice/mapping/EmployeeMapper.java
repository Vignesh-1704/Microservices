package com.m2p.employeeservice.mapping;

import com.m2p.employeeservice.dto.EmployeeDto;
import com.m2p.employeeservice.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {
    EmployeeMapper MAPPER = Mappers.getMapper(EmployeeMapper.class);

    // Employee JPA Entity to EmployeeDto
    EmployeeDto maptoEmployeeDto(Employee employee);

    // EmployeeDTO to Employee Entity
    Employee mapToEmployee(EmployeeDto employeeDto);

    /*  MapStruct provides the Implementation for this in Runtime  */
}
