package com.phoneshop.exceptions;

import com.phoneshop.entities.Supply;

public class NoStockException extends RuntimeException {

    public NoStockException() {
        super("Movement could not be created due to lack of stock of one or more supplies");
    }

    public NoStockException(Supply supply) {
        super("Movement could not be created due to lack of stock of " + supply.getSupplyName() + " supplies");
    }
}
