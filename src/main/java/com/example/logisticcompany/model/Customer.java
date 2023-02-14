package com.example.logisticcompany.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Entity
@Table(name = "customer")
@Getter
@Setter
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "customerId")
public class Customer {

    @Column(nullable = false)
    private String name;

    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false)
    private UUID customerId;

    // this way we fix circular reference problem - stack overflow error
    @JsonIgnore
    @ManyToMany(mappedBy = "customerList")
    private Set<Company> companies = new HashSet<>();

    @ManyToMany
    @JoinTable(name="customer_shipment",
                joinColumns = @JoinColumn(name="customerId"),
                inverseJoinColumns = @JoinColumn(name="shipmentId"))
    private Set<Shipment> customer_shipments = new HashSet<>();
}
