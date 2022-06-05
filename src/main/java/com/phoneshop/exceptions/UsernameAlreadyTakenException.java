package com.phoneshop.exceptions;

public class UsernameAlreadyTakenException extends RuntimeException {

    public UsernameAlreadyTakenException() {
        super("Username already taken");
    }

    public UsernameAlreadyTakenException(String message) {
        super(message);
    }

}
