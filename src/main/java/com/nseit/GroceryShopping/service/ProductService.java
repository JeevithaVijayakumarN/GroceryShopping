package com.nseit.GroceryShopping.service;

import com.nseit.GroceryShopping.model.Product;
import com.nseit.GroceryShopping.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    public ProductRepository productRepository;
    public void addProduct(Product product){
        productRepository.save(product);

    }public void updateProduct(){

    }public void viewProduct(){

    }public void deleteProduct(){

    }

}
