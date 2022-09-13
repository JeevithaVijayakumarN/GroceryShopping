package com.nseit.GroceryShopping.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequest {
    private Integer id;
    private Integer categoryId;
    private String productName;
    private Integer price;
}

