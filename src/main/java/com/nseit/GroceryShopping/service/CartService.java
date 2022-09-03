package com.nseit.GroceryShopping.service;

import com.nseit.GroceryShopping.model.Cart;
import com.nseit.GroceryShopping.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service

public class CartService {
    @Autowired
    private CartRepository cartRepository;

        public void addCart(@RequestBody Cart cart){
            cartRepository.save(cart);

        }public void updateCart(){

        }public void viewCart(){

        }public void deleteCart(){

        }
    }


