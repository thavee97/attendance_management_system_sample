package com.Customer.customer.ResponsDto;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class OrderResponse {
    private Long id;
    private String item;
    private double payment;
}
