package com.nseit.GroceryShopping.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private GroceryUser groceryUser;
    @ManyToMany
    @JoinTable(name = "cart_products", joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "productId"))
    private Set<Product> products;
}
