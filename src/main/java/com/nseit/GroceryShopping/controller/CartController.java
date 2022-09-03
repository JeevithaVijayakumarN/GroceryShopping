package com.nseit.GroceryShopping.controller;

import com.nseit.GroceryShopping.model.Cart;
import com.nseit.GroceryShopping.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/grocery")
public class CartController {
    @Autowired
    private CartService cartService;
    public void addCart(Cart cart){
        cartService.addCart(cart);

    }public void updateCart(){

    }public void viewCart(){

    }public void deleteCart(){

    }
}

