package com.enoca.Employee.Management.dto;

public record EmployeeDto(
        String employeeName,
        String employeeLastName,
        String employeeId,
        CompanyDto companyDto){
}