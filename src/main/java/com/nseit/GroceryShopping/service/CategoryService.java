package com.nseit.GroceryShopping.service;

import com.nseit.GroceryShopping.model.Category;
import com.nseit.GroceryShopping.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    public CategoryRepository categoryRepository;
    public Category addCategory(Category category){
        categoryRepository.save(category);

        return category;
    }public void updateCategory(){

    }public void viewCategory(){

    }public void deleteCategory(){

    }
}
