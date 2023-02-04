package com.example.logisticcompany.model;

import com.example.logisticcompany.repository.CompanyRepository;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

import java.util.*;

@Entity
@Table(name = "shipment")
@Getter
@Setter
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "shipmentId")
public class Shipment {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false)
    private UUID shipmentId;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;

    @OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    private Customer sender;

    @OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    private Customer receiver;

    @OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    private CompanyOffice officeFrom;

    @OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    private CompanyOffice officeTo;
}
