package com.enoca.Employee.Management.dto.request;

import jakarta.validation.constraints.NotBlank;


public record CreateCompanyRequest(
    @NotBlank
    String companyName
){
}
