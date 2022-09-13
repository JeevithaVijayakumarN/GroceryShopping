package com.nseit.GroceryShopping.repository;

import com.nseit.GroceryShopping.model.Cart;
import com.nseit.GroceryShopping.model.CartGrocery;
import com.nseit.GroceryShopping.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface CartGroceryRepository extends JpaRepository<CartGrocery,Integer> {

}
