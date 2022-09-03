package com.nseit.GroceryShopping.controller;

import com.nseit.GroceryShopping.model.Product;
import com.nseit.GroceryShopping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")

public class ProductController {
    @Autowired
    public ProductService productService;
    @PostMapping
    public void addProduct(@RequestBody Product product){
        productService.addProduct(product);

    }public void updateProduct(){

    }public void viewProduct(){

    }public void deleteProduct(){

    }
}
