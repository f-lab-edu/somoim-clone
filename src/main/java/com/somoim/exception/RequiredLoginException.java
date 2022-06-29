package com.somoim.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class RequiredLoginException extends RuntimeException {

    public RequiredLoginException(String message) {
        super(message);
    }
}