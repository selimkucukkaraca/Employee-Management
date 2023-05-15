package com.enoca.Employee.Management.dto.converter;

import com.enoca.Employee.Management.dto.EmployeeDto;
import com.enoca.Employee.Management.dto.request.CreateEmployeeRequest;
import com.enoca.Employee.Management.model.Company;
import com.enoca.Employee.Management.model.Employee;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
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

    public Employee toEntity(CreateEmployeeRequest request, Company company){
        return new Employee(
                request.getEmployeeName(),
                request.getEmployeeLastName(),
                company
        );
    }

}