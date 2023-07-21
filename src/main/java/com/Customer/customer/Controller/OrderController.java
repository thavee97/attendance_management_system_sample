package com.Customer.customer.Controller;

import com.Customer.customer.RequestDto.OrderRequest;
import com.Customer.customer.ResponsDto.OrderResponse;
import com.Customer.customer.Service.OrderService;
import com.Customer.customer.entities.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/createOrder")
    public void createOrder(@RequestBody OrderRequest orderRequest){

        orderService.createOrder(orderRequest);
    }
    @GetMapping("/getAllOrder")
    public List<OrderResponse> getAllOrder(){
        return orderService.getAllOrder();
    }

    @GetMapping("/getOrderById/{id}")
    public OrderResponse getOrderById(@PathVariable Long id){
        return orderService.getOrderById(id);
    }

    @PutMapping("/updateOrder")
    public void updateOrder(@RequestBody OrderRequest orderRequest){
        orderService.updateOrder(orderRequest);
    }

    @DeleteMapping("/deleteOrderById/{id}")
    public void deleteOrder(@PathVariable Long id){
        orderService.deleteOrder(id);
    }


}
