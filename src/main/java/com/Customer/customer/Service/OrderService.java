package com.Customer.customer.Service;

import com.Customer.customer.RequestDto.OrderRequest;
import com.Customer.customer.ResponsDto.OrderResponse;

import java.util.List;


public interface OrderService {
    public void createOrder(OrderRequest orderRequest);
    public List<OrderResponse> getAllOrder();
//
   public OrderResponse getOrderById(Long id);
   public void updateOrder(OrderRequest orderRequest);
    public void deleteOrder(Long id);
}
