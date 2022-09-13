package com.nseit.GroceryShopping.service;

import com.nseit.GroceryShopping.exception.ResourceAlreadyExistException;
import com.nseit.GroceryShopping.exception.ResourceNotFoundException;
import com.nseit.GroceryShopping.model.Cart;
import com.nseit.GroceryShopping.model.GroceryUser;
import com.nseit.GroceryShopping.model.Role;
import com.nseit.GroceryShopping.repository.CartRepository;
import com.nseit.GroceryShopping.repository.RoleRepository;
import com.nseit.GroceryShopping.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private RoleRepository roleRepository;

    public GroceryUser registerAsCustomer(GroceryUser groceryUser) {
        GroceryUser user = userRepository.findByUserName(groceryUser.getUserName());
        if (user != null) {
            throw new ResourceAlreadyExistException("User Already Exception");
        }
        Role role = roleRepository.findByName(Role.USER);
        groceryUser.setRoles(Set.of(role));
        groceryUser.setPassword(bCryptPasswordEncoder.encode(groceryUser.getPassword()));
        groceryUser = userRepository.save(groceryUser);
        System.out.println(groceryUser.toString());
        Cart cart = new Cart();
        cart.setGroceryUser(groceryUser);
        cartRepository.save(cart);
        return groceryUser;
    }

    public GroceryUser loginAsCustomer(GroceryUser groceryUser) {
        GroceryUser user = userRepository.findByUserName(groceryUser.getUserName());
        if (user != null && bCryptPasswordEncoder.matches(groceryUser.getPassword(), user.getPassword())) {
            return user;
        } else {
            throw new ResourceNotFoundException("Invalid username or password.");
        }
    }
}
