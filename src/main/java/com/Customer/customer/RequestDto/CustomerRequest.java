package com.Customer.customer.RequestDto;

import com.Customer.customer.entities.Orders;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CustomerRequest {
    private Long id;
    private String name;
    private Long employeeId;

}
