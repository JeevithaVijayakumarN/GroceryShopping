package com.nseit.GroceryShopping.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer productId;
    private String productName;
    private Integer price;
    @ManyToOne(cascade = CascadeType.ALL)
    private Category category;
    @ManyToMany(mappedBy = "products",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Order> orders;
    @ManyToMany(mappedBy = "products",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Cart> carts;


}
