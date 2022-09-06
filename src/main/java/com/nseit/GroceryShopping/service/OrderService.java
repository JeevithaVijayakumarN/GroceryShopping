package com.nseit.GroceryShopping.service;

import com.nseit.GroceryShopping.model.OrderProducts;
import com.nseit.GroceryShopping.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    public void addOrder(@RequestBody OrderProducts orderProducts){
        orderRepository.save(orderProducts);

    }public void updateOrder(){

    }public void viewOrder(){

    }public void deleteOrder(){

    }
}
