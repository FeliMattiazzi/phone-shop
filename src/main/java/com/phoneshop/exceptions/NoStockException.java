package com.phoneshop.exceptions;

@SuppressWarnings("serial")
public class NoStockException extends RuntimeException {

    public NoStockException() {
        super("Movement could not be created due to lack of stock of one or more supplies");
    }

}
