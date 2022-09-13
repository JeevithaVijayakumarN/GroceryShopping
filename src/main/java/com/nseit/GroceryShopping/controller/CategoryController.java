package com.nseit.GroceryShopping.controller;

import com.nseit.GroceryShopping.exception.ResourceNotFoundException;
import com.nseit.GroceryShopping.exception.UnableToInsertException;
import com.nseit.GroceryShopping.exception.UnableToUpdateException;
import com.nseit.GroceryShopping.model.Category;
import com.nseit.GroceryShopping.model.Product;
import com.nseit.GroceryShopping.response.APIResponse;
import com.nseit.GroceryShopping.response.SuccessResponse;
import com.nseit.GroceryShopping.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
@CrossOrigin(value = {"http://localhost:3000"})
public class CategoryController {
    @Autowired
    public CategoryService categoryService;
    @Autowired
    public APIResponse apiResponse;


//    @Secured({Role.ROLE_ADMIN})
    @PostMapping
    public ResponseEntity<APIResponse> addCategory(@RequestBody Category category) {
        Category addedCategory = categoryService.addCategory(category);
        if (addedCategory == null) {
            throw new UnableToInsertException("Unable to insert Category");
        }
        apiResponse.setStatus(HttpStatus.CREATED.value());
        apiResponse.setData(addedCategory);
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

//    @Secured({Role.ROLE_ADMIN})
    @PutMapping
    public ResponseEntity<APIResponse> updateCategory(@RequestBody Category category) {
        Category updatedCategory = categoryService.updateCategory(category);
        if (updatedCategory == null) {
            throw new UnableToUpdateException("Unable to update Category");
        }
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(updatedCategory);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

//    @Secured({Role.ROLE_ADMIN})
    @DeleteMapping("/{categoryId}")
    public ResponseEntity<APIResponse> deleteCategory(@PathVariable Integer categoryId) {
        categoryService.deleteCategory(categoryId);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(new SuccessResponse());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

//    @Secured({Role.ROLE_ADMIN, Role.ROLE_USER})
    @GetMapping("/all")
    public ResponseEntity<APIResponse> viewAllCategories() {
        List<Category> categories = categoryService.viewAllCategories();
        if (categories == null) {
            throw new ResourceNotFoundException("Unable to view Category");
        }
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(categories);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
