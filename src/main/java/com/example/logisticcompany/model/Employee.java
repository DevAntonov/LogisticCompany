package com.example.logisticcompany.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "employees")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "employeeId")
public class Employee {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false)
    private UUID employeeID;
    private String name;
    private String email;
    private String phone;
    private EmployeeRole role;

    @ManyToOne
    @JoinColumn(name = "company_company_id")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "company_office_company_office_id")
    private CompanyOffice companyOffice;
}
