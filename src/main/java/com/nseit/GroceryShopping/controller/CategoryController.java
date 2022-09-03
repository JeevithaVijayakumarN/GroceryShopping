package com.nseit.GroceryShopping.controller;

import com.nseit.GroceryShopping.model.Category;
import com.nseit.GroceryShopping.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/grocery/category")
public class CategoryController {
    @Autowired
    public CategoryService categoryService;
    @PostMapping
    public void addService(@RequestBody Category category){
        categoryService.addCategory(category);

    }public void updateService(){

    }public void viewService(){

    }public void deleteService(){

    }
}
