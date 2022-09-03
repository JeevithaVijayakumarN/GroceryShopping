package com.nseit.GroceryShopping.controller;

import com.nseit.GroceryShopping.model.GroceryUser;
import com.nseit.GroceryShopping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<GroceryUser> register(@RequestBody GroceryUser groceryUser) {
        GroceryUser registeredUser = userService.registerAsCustomer(groceryUser);
        if (registeredUser == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(registeredUser, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<GroceryUser> login(@RequestBody GroceryUser groceryUser) {
       GroceryUser loggedInUser = userService.loginAsCustomer(groceryUser);
        if (loggedInUser == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(loggedInUser, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<GroceryUser>> getAllUsers() {
        List<GroceryUser> groceryUsers= userService.getAllUsers();
        if (groceryUsers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(groceryUsers, HttpStatus.OK);
    }
}

