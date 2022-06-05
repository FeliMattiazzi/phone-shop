package com.phoneshop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler({BadRequestException.class})
    public ResponseEntity<ResponseMessage> handleBadRequestException(RuntimeException e) {

        return new ResponseEntity(new ResponseMessage(400, e.getMessage()), HttpStatus.BAD_REQUEST);

    }

    @org.springframework.web.bind.annotation.ExceptionHandler({NotFoundException.class})
    public ResponseEntity<ResponseMessage> handleNotFoundException(RuntimeException e) {

        return new ResponseEntity(new ResponseMessage(404, e.getMessage()), HttpStatus.NOT_FOUND);

    }

    @org.springframework.web.bind.annotation.ExceptionHandler({NoStockException.class})
    public ResponseEntity<ResponseMessage> handleNoStockException(RuntimeException e) {

        return new ResponseEntity(new ResponseMessage(e.getMessage()), HttpStatus.BAD_REQUEST);

    }

    @org.springframework.web.bind.annotation.ExceptionHandler({UsernameAlreadyTakenException.class})
    public ResponseEntity<ResponseMessage> handleUserAlreadyExistsException(RuntimeException e) {

        return new ResponseEntity(new ResponseMessage(e.getMessage()), HttpStatus.BAD_REQUEST);

    }

}
