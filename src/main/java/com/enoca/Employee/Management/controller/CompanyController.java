package com.enoca.Employee.Management.controller;

import com.enoca.Employee.Management.dto.CompanyDto;
import com.enoca.Employee.Management.dto.request.CreateCompanyRequest;
import com.enoca.Employee.Management.dto.request.UpdateCompanyRequest;
import com.enoca.Employee.Management.service.CompanyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.enoca.Employee.Management.constants.EndpointPath.COMPANY;

import java.util.List;

@RestController
@RequestMapping(COMPANY)
@CrossOrigin
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping
    public ResponseEntity<CompanyDto> save(@RequestBody @Valid CreateCompanyRequest request){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(companyService.createCompany(request));
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam String companyId) {
        companyService.deleteCompany(companyId);
        return ResponseEntity
                .noContent()
                .build();
    }

    @GetMapping
    public ResponseEntity<List<CompanyDto>> getAll(@RequestParam("page") int page, @RequestParam("size") int size){
        return ResponseEntity
                .ok(companyService.getAllCompany(page,size));
    }

    @PutMapping
    public ResponseEntity<CompanyDto> update(@RequestBody @Valid UpdateCompanyRequest request) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(companyService.update(request));
    }
}
