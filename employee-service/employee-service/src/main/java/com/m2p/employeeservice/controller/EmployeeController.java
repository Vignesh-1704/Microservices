package com.m2p.employeeservice.controller;

import com.m2p.employeeservice.dto.EmployeeDto;
import com.m2p.employeeservice.entity.Employee;
import com.m2p.employeeservice.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto)
    {
        EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("{employee-id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable(name = "employee-id") Long employeeID)
    {
        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeID);
        return new ResponseEntity<>(employeeDto,HttpStatus.OK);
    }
}
