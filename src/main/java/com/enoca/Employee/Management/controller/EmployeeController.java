package com.enoca.Employee.Management.controller;

import com.enoca.Employee.Management.dto.EmployeeDto;
import com.enoca.Employee.Management.dto.request.CreateEmployeeRequest;
import com.enoca.Employee.Management.model.Company;
import com.enoca.Employee.Management.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
@CrossOrigin
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> save(@RequestBody CreateEmployeeRequest request, @RequestBody Company company){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(employeeService.createEmployee(request, company));
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam String employeeId) {
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity
                .noContent()
                .build();
    }

    @GetMapping("/get-all-employee")
    public ResponseEntity <List<EmployeeDto>> getAll(@RequestParam int size, @RequestParam int page){
        return ResponseEntity
                .ok(employeeService.getAllEmployee(size,page));
    }


}
