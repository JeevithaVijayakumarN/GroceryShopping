package com.nseit.GroceryShopping.controller;
import com.nseit.GroceryShopping.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")

public class OrderController {
    @Autowired
    private OrderService orderService;
//    public void addOrder(OrderProducts orderProducts){
//        orderService.addOrder(orderProducts);
//
//    }public void updateOrder(){
//
//    }public void viewOrder(){
//
//    }public void deleteOrder(){
//
//    }
}
