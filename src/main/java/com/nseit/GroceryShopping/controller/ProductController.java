package com.nseit.GroceryShopping.controller;

import com.nseit.GroceryShopping.model.Product;
import com.nseit.GroceryShopping.request.ProductRequest;
import com.nseit.GroceryShopping.response.APIResponse;
import com.nseit.GroceryShopping.response.SuccessResponse;
import com.nseit.GroceryShopping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@CrossOrigin(value = {"http://localhost:3000"})

public class ProductController {
    @Autowired
    public ProductService productService;
    @Autowired
    private APIResponse apiResponse;

//    @Secured({Role.ROLE_ADMIN})
    @PostMapping
    public ResponseEntity<APIResponse> addProduct(@RequestBody ProductRequest productRequest) {
       Product addedProduct = productService.addProduct(productRequest);
        apiResponse.setStatus(HttpStatus.CREATED.value());
        apiResponse.setData(addedProduct);
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

//    @Secured({Role.ROLE_ADMIN})
    @PutMapping
    public ResponseEntity<APIResponse> updateProduct(@RequestBody ProductRequest productRequest) {
        Product updatedProduct = productService.updateProduct(productRequest);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(updatedProduct);
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

//    @Secured({Role.ROLE_ADMIN})
    @DeleteMapping("/{productId}")
    public ResponseEntity<APIResponse> deleteProduct(@PathVariable Integer productId) {
       productService.deleteProduct(productId);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(new SuccessResponse());
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

//    @Secured({Role.ROLE_ADMIN, Role.ROLE_USER})
    @GetMapping("/all")
    public ResponseEntity<APIResponse> viewAllProducts() {
        List<Product> products = productService.viewAllProducts();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(products);
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

//    @Secured({Role.ROLE_ADMIN, Role.ROLE_USER})
    @GetMapping("/{productId}")
    public ResponseEntity<APIResponse> viewProductById(@PathVariable Integer productId) {
        Product product = productService.findProductById(productId);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(product);
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

}
