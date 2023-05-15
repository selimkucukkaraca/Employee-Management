package com.enoca.Employee.Management.repository;

import com.enoca.Employee.Management.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findEmployeeByEmployeeId(String employeeId);
}
