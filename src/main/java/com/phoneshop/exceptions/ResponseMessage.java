package com.phoneshop.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class ResponseMessage {

    private int errorCode;
    private String message;

    public ResponseMessage(String message) {
        this.message = message;
    }

}
