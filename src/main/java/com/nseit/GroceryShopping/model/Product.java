package com.nseit.GroceryShopping.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String productName;
    private Integer price;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id",nullable=false)
    private Category category;

    @ManyToMany(mappedBy = "products",cascade = CascadeType.ALL)
    private Set<OrderProducts> orderProducts;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private Set<CartGrocery> cartGroceries;

}
