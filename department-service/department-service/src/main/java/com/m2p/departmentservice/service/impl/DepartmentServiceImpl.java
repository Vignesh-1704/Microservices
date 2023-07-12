package com.m2p.departmentservice.service.impl;

import com.m2p.departmentservice.dto.DepartmentDto;
import com.m2p.departmentservice.entity.Department;
import com.m2p.departmentservice.mapping.DepartmentMapper;
import com.m2p.departmentservice.repository.DepartmentRepository;
import com.m2p.departmentservice.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        // Convert Department DTO to Entity to save it to DB.
        Department department = DepartmentMapper.MAPPER.mapToDepartment(departmentDto);
        Department savedDepartment  = departmentRepository.save(department);
        return DepartmentMapper.MAPPER.mapToDepartmentDto(savedDepartment);
    }

    @Override
    public DepartmentDto getDepartmentByCode(String code) {
        Department department = departmentRepository.findByDepartmentCode(code);
        return DepartmentMapper.MAPPER.mapToDepartmentDto(department);
    }


}
