package com.nseit.GroceryShopping.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "groceryorder")

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int order_id;
    private Date date;
    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private GroceryUser groceryUser;
    @ManyToMany
    @JoinTable(name = "ordered_products",
            joinColumns=@JoinColumn(name = "order_id",referencedColumnName = "order_id"),
            inverseJoinColumns=@JoinColumn(name = "product_id",referencedColumnName = "productId"))
    private Set<Product>products;



}
