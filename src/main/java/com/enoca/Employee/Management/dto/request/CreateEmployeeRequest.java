package com.enoca.Employee.Management.dto.request;

import com.enoca.Employee.Management.model.Company;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateEmployeeRequest {
    private String employeeName;
    private String employeeLastName;
    private Company company;

}
