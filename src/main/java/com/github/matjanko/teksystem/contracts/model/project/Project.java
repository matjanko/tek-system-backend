package com.github.matjanko.teksystem.contracts.model.project;

import com.github.matjanko.teksystem.contracts.model.customer.Customer;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "PROJECT")
@Getter
public class Project {

    @Id
    @Column(name = "PROJECT_ID")
    private Long id;

    @Column(name = "PROJECT_NAME")
    private String name;

    @Column(name = "PROJECT_SYMBOL")
    private Character symbol;

    @Column(name = "PROJECT_INDEX")
    private Long index;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;
}
