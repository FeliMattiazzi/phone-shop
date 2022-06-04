package com.phoneshop.exceptions;

public class NoStockException extends RuntimeException {

    public NoStockException() {
        super("Movement could not be created due to lack of stock of one or more supplies");
    }

}
