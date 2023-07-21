package com.Customer.customer.Service.Imple;

import com.Customer.customer.Repository.OrderRepository;
import com.Customer.customer.RequestDto.OrderRequest;
import com.Customer.customer.ResponsDto.OrderResponse;
import com.Customer.customer.Service.OrderService;
import com.Customer.customer.entities.Orders;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;


    @Override
    public void createOrder(OrderRequest orderRequest) {
        Orders order=new Orders();
        //order.setId(orderRequest.getId());
        BeanUtils.copyProperties(orderRequest,order);
        orderRepository.save(order);
    }

    @Override
    public List<OrderResponse> getAllOrder() {
       List<OrderResponse> orderResponseList=new ArrayList<>();
       List<Orders> orderslist=orderRepository.findAll();
       for(Orders order:orderslist){
           OrderResponse orderResponse=new OrderResponse();
           BeanUtils.copyProperties(order,orderResponse);
           orderResponseList.add(orderResponse);
       }
        return orderResponseList;
    }

    @Override
    public OrderResponse getOrderById(Long id) {
        Orders order=orderRepository.findById(id).get();
        OrderResponse orderResponse=new OrderResponse();
        BeanUtils.copyProperties(order,orderResponse);

        return orderResponse;
    }

    @Override
    public void updateOrder(OrderRequest orderRequest) {
        Orders order=orderRepository.findById(orderRequest.getId()).get();
        BeanUtils.copyProperties(orderRequest,order);
        orderRepository.save(order);
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }


}
