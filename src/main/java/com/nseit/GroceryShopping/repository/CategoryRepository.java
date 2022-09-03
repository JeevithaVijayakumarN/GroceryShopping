package com.nseit.GroceryShopping.repository;

import com.nseit.GroceryShopping.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
