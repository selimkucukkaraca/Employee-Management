package com.enoca.Employee.Management.dto.request;

import jakarta.validation.constraints.NotBlank;

public record UpdateCompanyRequest(
        @NotBlank
        String companyId,
        @NotBlank
        String companyName
) {
}
