package com.github.matjanko.teksystem.contracts.model.customer;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "CUSTOMER")
@Getter @Setter
public class Customer {

    @Id
    @SequenceGenerator(name = "CUSTOMER_SEQUENCE", sequenceName = "CUSTOMER_SEQUENCE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUSTOMER_SEQUENCE")
    @Column(name = "CUSTOMER_ID")
    private Long id;

    @Column(name = "CUSTOMER_NAME", unique = true, nullable = false)
    private String name;
}
