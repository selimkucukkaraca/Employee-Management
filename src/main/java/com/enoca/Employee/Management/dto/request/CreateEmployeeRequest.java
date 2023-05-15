package com.enoca.Employee.Management.dto.request;

import jakarta.validation.constraints.NotBlank;

public record CreateEmployeeRequest(
    @NotBlank
    String employeeName,
    @NotBlank
    String employeeLastName,
    @NotBlank
    String companyId

){
}
