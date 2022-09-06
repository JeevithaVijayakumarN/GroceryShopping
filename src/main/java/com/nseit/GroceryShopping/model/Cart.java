package com.nseit.GroceryShopping.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private GroceryUser groceryUser;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private Set<CartGrocery> cartGroceries;

}
