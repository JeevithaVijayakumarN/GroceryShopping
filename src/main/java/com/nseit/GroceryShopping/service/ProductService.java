package com.nseit.GroceryShopping.service;

import com.nseit.GroceryShopping.exception.ResourceAlreadyExistException;
import com.nseit.GroceryShopping.exception.ResourceNotFoundException;
import com.nseit.GroceryShopping.model.Category;
import com.nseit.GroceryShopping.model.Product;
import com.nseit.GroceryShopping.repository.CategoryRepository;
import com.nseit.GroceryShopping.repository.ProductRepository;
import com.nseit.GroceryShopping.request.ProductRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    public ProductRepository productRepository;

    @Autowired
    public CategoryRepository categoryRepository;
    public Product addProduct(ProductRequest productRequest) {
        Product product = new Product();
        BeanUtils.copyProperties(productRequest, product);

        Category category = categoryRepository.findById(productRequest.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category with id "
                        + productRequest.getCategoryId()));
        product.setCategory(category);

        boolean isProductExists = productRepository.findByProductName(productRequest.getProductName()).isPresent();
        if (isProductExists)
            throw new ResourceAlreadyExistException("Book already exists.");

        return productRepository.save(product);
    }

    public Product updateProduct(ProductRequest productRequest) {
        Product product = new Product();
        BeanUtils.copyProperties(productRequest, product);
        if (productRequest.getId() == null)
            throw new ResourceNotFoundException("No book with id "
                    + productRequest.getId());
        Category category = categoryRepository.findById(productRequest.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("No category with category id "
                        + productRequest.getCategoryId()));
        product.setCategory(category);
        return productRepository.save(product);
    }

    public void deleteProduct(Integer productId) {
       productRepository.findById(productId).orElseThrow(() ->
                new ResourceNotFoundException("No book with id "
                        + productId));
        productRepository.deleteById(productId);
    }

    public List<Product> viewAllProducts() {
        return productRepository.findAll();
    }

    public Product findProductById(Integer productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Unable to find book with id " + productId));
    }

}
