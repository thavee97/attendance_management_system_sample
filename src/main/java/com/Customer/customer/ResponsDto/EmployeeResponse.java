package com.Customer.customer.ResponsDto;

import com.Customer.customer.entities.Address;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class EmployeeResponse {

    private Long id;
    private String name;
    private int age;
    private double salary;
    private Long addressid;
    private String addcity;
}
