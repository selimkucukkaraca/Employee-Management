package com.enoca.Employee.Management.service;

import com.enoca.Employee.Management.dto.EmployeeDto;
import com.enoca.Employee.Management.dto.converter.EmployeeConverter;
import com.enoca.Employee.Management.dto.request.CreateEmployeeRequest;
import com.enoca.Employee.Management.dto.request.UpdateEmployeeRequest;
import com.enoca.Employee.Management.exception.NotFoundException;
import com.enoca.Employee.Management.model.Company;
import com.enoca.Employee.Management.model.Employee;
import com.enoca.Employee.Management.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeConverter employeeConverter;
    private final CompanyService companyService;

    public EmployeeDto createEmployee(CreateEmployeeRequest request){
        Company company = companyService.getCompanyByCompanyId(request.companyId());
        var saved = employeeConverter.toEntity(request);
        saved.setCompany(company);
        employeeRepository.save(saved);
        return employeeConverter.convertToDto(saved);
    }

    public List<EmployeeDto> getAllEmployee(int page, int size){
        Pageable pageable = PageRequest.of(page,size);

        return employeeRepository.findAll(pageable)
                .stream()
                .map(employeeConverter::convertToDto)
                .toList();
    }
    public void deleteEmployee(String employeeId){
        var employee = getEmployeeByEmployeeId(employeeId);
        employeeRepository.delete(employee);
    }

    protected Employee getEmployeeByEmployeeId(String employeeId){
        return employeeRepository.findEmployeeByEmployeeId(employeeId)
                .orElseThrow(() -> new NotFoundException("Employee Id not found: " + employeeId));
    }

    public EmployeeDto update(UpdateEmployeeRequest request){
        var fromDb = getEmployeeByEmployeeId(request.employeeId());
        fromDb.setEmployeeName(request.employeeName());
        fromDb.setEmployeeLastName(request.employeeLastName());
        employeeRepository.save(fromDb);
        return employeeConverter.convertToDto(fromDb);
    }
}