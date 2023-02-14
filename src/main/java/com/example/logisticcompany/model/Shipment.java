package com.example.logisticcompany.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

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

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "customerId")
    private Customer sender;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false)
    private Customer receiver;

    // трябва винаги да е сетнат; всяка пратка тръгва от офис.
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false)
    private Office officeFrom;

    // трябва винаги да е сетнат, дори и да имаме адрессТо(ако човек не приеме пратката си, да отиде до офис)
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false)
    private Office officeTo;

    private String addressTo;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Double weight;

    public enum status {
        inTransit, arrived, received
    }

    ;
}
