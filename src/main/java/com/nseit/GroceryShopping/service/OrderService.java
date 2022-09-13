package com.nseit.GroceryShopping.service;

import com.nseit.GroceryShopping.exception.ResourceNotFoundException;
import com.nseit.GroceryShopping.model.Cart;
import com.nseit.GroceryShopping.model.GroceryUser;
import com.nseit.GroceryShopping.model.OrderProducts;
import com.nseit.GroceryShopping.model.Product;
import com.nseit.GroceryShopping.repository.CartRepository;
import com.nseit.GroceryShopping.repository.OrderRepository;
import com.nseit.GroceryShopping.repository.UserRepository;
import com.nseit.GroceryShopping.request.OrderAllRequest;
import com.nseit.GroceryShopping.response.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashSet;
import java.util.Set;


@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;


}
