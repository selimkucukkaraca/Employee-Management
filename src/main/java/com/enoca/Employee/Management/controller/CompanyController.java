package com.enoca.Employee.Management.controller;

import com.enoca.Employee.Management.dto.CompanyDto;
import com.enoca.Employee.Management.dto.request.CreateCompanyRequest;
import com.enoca.Employee.Management.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/company")
@CrossOrigin
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping
    public ResponseEntity<CompanyDto> save(@RequestBody CreateCompanyRequest request){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(companyService.createCompany(request));
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam String companyId) {
        companyService.deleteCompany(companyId);
        return ResponseEntity
                .noContent()
                .build();
    }

    @GetMapping("/get-all-company")
    public ResponseEntity <List<CompanyDto>> getAll(@RequestParam int size, @RequestParam int page){
        return ResponseEntity
                .ok(companyService.getAllCompany(size,page));
    }
}
