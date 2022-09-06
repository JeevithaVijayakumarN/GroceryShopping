package com.nseit.GroceryShopping.repository;

import com.nseit.GroceryShopping.model.OrderProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface OrderRepository extends JpaRepository<OrderProducts,Integer> {

}
