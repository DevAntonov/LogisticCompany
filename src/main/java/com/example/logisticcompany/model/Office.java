package com.example.logisticcompany.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "office")
@Getter
@Setter
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "companyOfficeId")
public class Office {

    @Column(nullable = false)
    private String officeAddress;

    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false)
    private UUID companyOfficeId;

    @ManyToOne(fetch = FetchType.EAGER)
    private Company company;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Shipment> shipments = new HashSet<>();

}
