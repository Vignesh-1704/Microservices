package com.m2p.departmentservice.mapping;

import com.m2p.departmentservice.dto.DepartmentDto;
import com.m2p.departmentservice.entity.Department;
import com.m2p.departmentservice.repository.DepartmentRepository;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/* MapStruct works only if both Entity and DTO has the same number of Fields
 *  And we can use @Mapping to map two object with different field names
 *  Example:
 *  In Source : Entity -> User -> private String emailAddress
 *  In Destination : DTO -> UserDto -> private String email
 *  We deal this by using :
 *  @Mapping(source = "emailAddress" , destination = "email)
 * */

@Mapper
public interface DepartmentMapper {
    DepartmentMapper MAPPER = Mappers.getMapper(DepartmentMapper.class);

    // Department JPA Entity to DepartmentDto
    DepartmentDto mapToDepartmentDto(Department department);

    // DepartmentDTO to Department Entity
    Department mapToDepartment(DepartmentDto departmentDto);

    /*  MapStruct provides the Implementation for this in Runtime  */
}
