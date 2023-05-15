package com.enoca.Employee.Management.service;

import com.enoca.Employee.Management.dto.EmployeeDto;
import com.enoca.Employee.Management.dto.converter.EmployeeConverter;
import com.enoca.Employee.Management.dto.request.CreateEmployeeRequest;
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

    public EmployeeDto createEmployee(CreateEmployeeRequest request, Company company){
        var saved = employeeConverter.toEntity(request,company);
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
                .orElseThrow();
    }

    protected void updateEmployee(Employee employee){
        employeeRepository.save(employee);
    }

}