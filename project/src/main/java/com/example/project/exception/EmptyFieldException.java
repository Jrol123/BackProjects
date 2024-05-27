package com.example.project.exception;

import org.springframework.http.HttpStatus;

public class EmptyFieldException extends ApiException {
    public EmptyFieldException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
