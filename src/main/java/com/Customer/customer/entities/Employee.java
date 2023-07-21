package com.Customer.customer.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    private double salary;
    @ManyToOne
    @JoinColumn(name = "address_Id",nullable = false)

    private Address address;
}
