package ru.demo.somebank.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.demo.somebank.exception.BusinessProcessException;
import ru.demo.somebank.exception.DataNotFoundException;

@ControllerAdvice
public class MainControllerAdvice {

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<Object> handleDataNotFoundException(DataNotFoundException e) {
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BusinessProcessException.class)
    public ResponseEntity<Object> handleBusinessProcessException(BusinessProcessException e) {
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
