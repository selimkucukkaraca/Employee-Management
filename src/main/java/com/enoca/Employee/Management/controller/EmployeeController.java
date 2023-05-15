package com.enoca.Employee.Management.controller;

import com.enoca.Employee.Management.dto.EmployeeDto;
import com.enoca.Employee.Management.dto.request.CreateEmployeeRequest;
import com.enoca.Employee.Management.dto.request.UpdateEmployeeRequest;
import com.enoca.Employee.Management.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.enoca.Employee.Management.constants.EndpointPath.EMPLOYEE;

import java.util.List;

@RestController
@RequestMapping(EMPLOYEE)
@CrossOrigin
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> save(@RequestBody @Valid CreateEmployeeRequest request){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(employeeService.createEmployee(request));
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam String employeeId) {
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity
                .noContent()
                .build();
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAll(@RequestParam("page") int page, @RequestParam("size") int size){
        return ResponseEntity
                .ok(employeeService.getAllEmployee(page,size));
    }

    @PutMapping
    public ResponseEntity<EmployeeDto> update(@RequestBody @Valid UpdateEmployeeRequest request){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(employeeService.update(request));
    }
}
