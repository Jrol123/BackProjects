package com.example.project.exception;

import org.springframework.http.HttpStatus;

public class UsersNotFoundException extends ApiException{
    public UsersNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
}
