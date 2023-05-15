package com.enoca.Employee.Management.dto.request;

import jakarta.validation.constraints.NotBlank;

public record UpdateEmployeeRequest(
        @NotBlank
        String employeeName,
        @NotBlank
        String employeeLastName,
        @NotBlank
        String employeeId
) {
}
