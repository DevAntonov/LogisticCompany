package com.example.logisticcompany.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "employees")
@Getter
@Setter
//@ToString
//@RequiredArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "employeeId")
public class Employee {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false)
    private UUID employeeId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phone;

    @ManyToOne
    @JoinColumn(name = "company_company_id")
    private Company company;

    @ManyToOne(optional = false)
    @JoinColumn(name = "company_office_company_office_id")
    private Office office;
}