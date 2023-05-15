package com.enoca.Employee.Management.service;

import com.enoca.Employee.Management.dto.CompanyDto;
import com.enoca.Employee.Management.dto.converter.CompanyConverter;
import com.enoca.Employee.Management.dto.request.CreateCompanyRequest;
import com.enoca.Employee.Management.model.Company;
import com.enoca.Employee.Management.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyConverter companyConverter;

    public CompanyDto createCompany(CreateCompanyRequest request){
        var saved = companyConverter.toEntity(request);
        companyRepository.save(saved);
        return companyConverter.convertToDto(saved);
    }

    public List<CompanyDto> getAllCompany(int page,int size){
        Pageable pageable = PageRequest.of(page,size);

        return companyRepository.findAll(pageable)
                .stream()
                .map(companyConverter::convertToDto)
                .toList();
    }

    public void deleteCompany(String companyId){
        var company = getCompanyByCompanyId(companyId);
        companyRepository.delete(company);
    }

    protected Company getCompanyByCompanyId(String companyId){
        return companyRepository.findCompanyByCompanyId(companyId)
                .orElseThrow();
    }

    protected void updateCompany(Company company){
        companyRepository.save(company);
    }

}