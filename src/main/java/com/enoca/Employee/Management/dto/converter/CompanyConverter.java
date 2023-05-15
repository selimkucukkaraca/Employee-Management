package com.enoca.Employee.Management.dto.converter;

import com.enoca.Employee.Management.dto.CompanyDto;
import com.enoca.Employee.Management.dto.request.CreateCompanyRequest;
import com.enoca.Employee.Management.model.Company;
import org.springframework.stereotype.Component;

@Component
public class CompanyConverter {

    public CompanyDto convertToDto(Company from){
        return new CompanyDto(
                from.getCompanyName(),
                from.getCompanyId()
        );
    }

    public Company toEntity(CreateCompanyRequest request){
        return new Company(request.companyName());
    }

}