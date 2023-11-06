package com.example.base.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND)
public class UserNotDefinedException extends RuntimeException {
    public UserNotDefinedException(String s) {

        super(s);
    }
}
