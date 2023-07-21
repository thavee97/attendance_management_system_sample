package com.Customer.customer.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Entity
@Setter
@Getter
public class Orders {
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int item;

    @ManyToOne
    @JoinColumn(name = "customer_id")

    private Customer customer;
//    @ManyToMany
//    @JoinColumn(name ="item_id" )
//    private List<Item> itemList;



}
