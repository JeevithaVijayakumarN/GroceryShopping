package com.nseit.GroceryShopping.service;

import com.nseit.GroceryShopping.exception.ResourceAlreadyExistException;
import com.nseit.GroceryShopping.exception.ResourceNotFoundException;
import com.nseit.GroceryShopping.model.Category;
import com.nseit.GroceryShopping.repository.CategoryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    public CategoryRepository categoryRepository;
    public Category addCategory(Category category) {
        BeanUtils.copyProperties(category,category);
        boolean isExists = categoryRepository.findByCategoryName(category.getCategoryName()).isPresent();
        if (isExists)
            throw new ResourceAlreadyExistException("Category already exists.");
        System.out.println(category);
        return categoryRepository.save(category);
    }

    public List<Category> viewAllCategories() {
        return categoryRepository.findAll();
    }

    public void deleteCategory(Integer categoryId) {
        categoryRepository.findById(categoryId).orElseThrow(() ->
                new ResourceNotFoundException("No category with id "
                        + categoryId));
        categoryRepository.deleteById(categoryId);
    }

    public Category updateCategory(Category category) {
        if (category.getId() != null && category.getId() > 0) {
            categoryRepository.findById(category.getId()).orElseThrow(
                    () -> new ResourceNotFoundException("No category with id "
                            + category.getId())
            );
            return categoryRepository.save(category);
        } else {
            throw new ResourceNotFoundException("Invalid category id");
        }
    }
}
