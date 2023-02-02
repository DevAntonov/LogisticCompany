package com.example.logisticcompany.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    private String companyName;

    @ManyToMany
    @JoinTable(name = "company_customer",
            joinColumns = @JoinColumn(name = "company_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id"))
    private Set<Customer> customerList = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Shipment> allShipments;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<CompanyOffice> offices;



}
