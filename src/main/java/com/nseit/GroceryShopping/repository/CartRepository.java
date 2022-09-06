package com.nseit.GroceryShopping.repository;

import com.nseit.GroceryShopping.model.Cart;
import com.nseit.GroceryShopping.model.GroceryUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository <Cart,Integer>{
//    Optional<Cart> findByGrocerUser(GroceryUser groceryUser);

}
