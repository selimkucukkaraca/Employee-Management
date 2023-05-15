package com.enoca.Employee.Management.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String employeeName;
    private String employeeLastName;
    private String employeeId = UUID.randomUUID().toString();
    @ManyToOne(cascade = CascadeType.ALL)
    private Company company;

    public Employee(String employeeName, String employeeLastName) {
        this.employeeName = employeeName;
        this.employeeLastName = employeeLastName;
    }
}