package com.nseit.GroceryShopping.controller;

import com.nseit.GroceryShopping.model.GroceryUser;
import com.nseit.GroceryShopping.response.APIResponse;
import com.nseit.GroceryShopping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private APIResponse apiResponse;

    @PostMapping("/register")
    public ResponseEntity<APIResponse> register(@RequestBody GroceryUser groceryUser) {
        GroceryUser registeredUser = userService.registerAsCustomer(groceryUser);

        apiResponse.setStatus(HttpStatus.CREATED.value());
        apiResponse.setData(registeredUser);
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<APIResponse> login(@RequestBody GroceryUser groceryUser) {
        GroceryUser loggedInUser = userService.loginAsCustomer(groceryUser);

        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(loggedInUser);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}

