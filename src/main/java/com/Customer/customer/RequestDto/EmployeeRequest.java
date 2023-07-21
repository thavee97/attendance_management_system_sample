package com.Customer.customer.RequestDto;

import com.Customer.customer.entities.Address;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmployeeRequest {
    private Long id;
    private String name;
    private int age;
    private double salary;
    private Long addressid;
   // private Long customerId;
}
