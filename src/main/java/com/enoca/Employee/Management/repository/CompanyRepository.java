package com.enoca.Employee.Management.repository;

import com.enoca.Employee.Management.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    Optional<Company> findCompanyByCompanyId(String companyId);
}
