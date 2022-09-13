package com.nseit.GroceryShopping.exception;

public class ResourceAlreadyExistException extends RuntimeException {
    public ResourceAlreadyExistException(String msg) {
        super(msg);
    }
}