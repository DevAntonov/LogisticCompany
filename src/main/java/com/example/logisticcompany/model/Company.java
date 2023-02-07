package com.example.logisticcompany.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Entity
@Table(name = "company")
@Getter
@Setter
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "companyId")
public class Company {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false)
    private UUID companyId;

    @Column(nullable = false)
    private String companyName;

    @ManyToMany
    @JoinTable(name = "company_customer",
            joinColumns = @JoinColumn(name = "company_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id"))
    private Set<Customer> customerList = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL/*, mappedBy = "company"*/)
    @JoinTable(name = "company_shipments",
            joinColumns = @JoinColumn(name = "company_id"),
            inverseJoinColumns = @JoinColumn(name = "shipment_id"))
    private Set<Shipment> allShipments;

    @OneToMany(cascade = CascadeType.ALL/*, mappedBy = "company"*/)
    @JoinTable(name = "company_offices",
            joinColumns = @JoinColumn(name = "company_id"),
            inverseJoinColumns = @JoinColumn(name = "ofiice_id"))
    private Set<Office> offices;


    @OneToMany(cascade = CascadeType.ALL)
    private Set<Employee> employees;



}
