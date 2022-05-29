package com.phoneshop.exceptions;

@SuppressWarnings("serial")
public class BadSupplyException extends RuntimeException{

    public BadSupplyException() {
        super("Trying to create a supply that doesn't exists in catalog");
    }

}
