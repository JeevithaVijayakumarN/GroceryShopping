package com.nseit.GroceryShopping.service;

import com.nseit.GroceryShopping.model.GroceryUser;
import com.nseit.GroceryShopping.model.Role;
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

    public GroceryUser registerAsCustomer(GroceryUser groceryUser) {
        Role role = new Role();
        role.setName(Role.ROLE_USER);
        groceryUser.setRoles(Set.of(role));
       groceryUser.setPassword(bCryptPasswordEncoder.encode(groceryUser.getPassword()));
        return userRepository.save(groceryUser);
    }

    public List<GroceryUser> getAllUsers() {
        return userRepository.findAll();
    }

    public GroceryUser loginAsCustomer(GroceryUser groceryUser) {
        GroceryUser user = userRepository.findByUserName(groceryUser.getUserName());
        if (user != null && bCryptPasswordEncoder.matches(user.getPassword(),groceryUser.getPassword())) {
            return user;
        }
        return null;
    }
}
