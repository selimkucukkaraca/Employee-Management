package com.enoca.Employee.Management.dto.converter;

import com.enoca.Employee.Management.dto.EmployeeDto;
import com.enoca.Employee.Management.dto.request.CreateEmployeeRequest;
import com.enoca.Employee.Management.model.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmployeeConverter {

    private final CompanyConverter companyConverter;

    public EmployeeDto convertToDto(Employee from){
        return new EmployeeDto(
                from.getEmployeeName(),
                from.getEmployeeLastName(),
                from.getEmployeeId(),
                companyConverter.convertToDto(from.getCompany())
        );
    }

    public Employee toEntity(CreateEmployeeRequest request){
        return new Employee(
                request.employeeName(),
                request.employeeLastName()
        );
    }

}