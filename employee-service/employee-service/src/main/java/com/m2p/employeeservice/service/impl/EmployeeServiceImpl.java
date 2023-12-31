package com.m2p.employeeservice.service.impl;

import com.m2p.employeeservice.dto.APIResponseDto;
import com.m2p.employeeservice.dto.DepartmentDto;
import com.m2p.employeeservice.dto.EmployeeDto;
import com.m2p.employeeservice.entity.Employee;
import com.m2p.employeeservice.mapping.EmployeeMapper;
import com.m2p.employeeservice.repository.EmployeeRepository;
import com.m2p.employeeservice.service.APIClient;
import com.m2p.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Injected the Rest Template
//    @Autowired
//    private RestTemplate restTemplate;


    // Injected the WebClient
//    @Autowired
//    private WebClient webClient;

    @Autowired
    private APIClient apiClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.MAPPER.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.MAPPER.maptoEmployeeDto(savedEmployee);
    }

    @Override
    public APIResponseDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).get();
        // Rest Template Implementation
        // Using Rest Template to hit the getDepartmentByCode API to get as every employee has unique Department Code
//        ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8082/api/departments/"+ employee.getDepartmentCode(), DepartmentDto.class);
//        DepartmentDto departmentDto = responseEntity.getBody();

        //WebClient Implementation
//        DepartmentDto departmentDto = webClient.get()
//                                            .uri("http://localhost:8082/api/departments")
//                                            .retrieve()
//                                            .bodyToMono(DepartmentDto.class)
//                                            .block();

        // Open Feign Implementation
        DepartmentDto departmentDto = apiClient.getDepartmentByCode(employee.getDepartmentCode());

        EmployeeDto employeeDto =  EmployeeMapper.MAPPER.maptoEmployeeDto(employee);

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);

        return apiResponseDto;
    }
}
