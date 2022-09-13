package com.nseit.GroceryShopping.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "orders")
public class OrderProducts {
    @Id
    @GeneratedValue
    private Integer id;
    private Boolean isCancelled = false;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private GroceryUser groceryUser;

    @ManyToMany
    @JoinTable(name = "ordered_products",
            joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Product> products;




    public OrderProducts() {
        this.dateTime = LocalDateTime.now();
    }
}
