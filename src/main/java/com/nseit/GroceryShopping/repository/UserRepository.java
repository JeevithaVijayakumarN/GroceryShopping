package com.nseit.GroceryShopping.repository;

import com.nseit.GroceryShopping.model.GroceryUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<GroceryUser,Long>{
    GroceryUser findByUserName(String userName);
}
