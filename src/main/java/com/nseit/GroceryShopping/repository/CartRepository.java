package com.nseit.GroceryShopping.repository;

import com.nseit.GroceryShopping.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CartRepository extends JpaRepository <Cart,Integer>{
}
