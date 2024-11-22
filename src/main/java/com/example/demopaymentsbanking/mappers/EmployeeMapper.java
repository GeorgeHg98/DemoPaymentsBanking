package com.example.demopaymentsbanking.mappers;

import com.example.demopaymentsbanking.dto.EmployeeDTO;
import com.example.demopaymentsbanking.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    EmployeeDTO toDTO(Employee employee);
    Employee toEntity(EmployeeDTO employeeDTO);
}
