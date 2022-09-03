package com.nseit.GroceryShopping.service;

import com.nseit.GroceryShopping.model.Cart;
import com.nseit.GroceryShopping.model.Order;
import com.nseit.GroceryShopping.model.Product;
import com.nseit.GroceryShopping.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    public void addOrder(@RequestBody Order order){
        orderRepository.save(order);

    }public void updateOrder(){

    }public void viewOrder(){

    }public void deleteOrder(){

    }
}
