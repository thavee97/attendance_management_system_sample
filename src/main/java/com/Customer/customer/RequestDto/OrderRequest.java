package com.Customer.customer.RequestDto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderRequest {
    private Long id;
    private int item ;
    private double payment;


}
