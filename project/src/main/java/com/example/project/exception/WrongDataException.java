package com.example.project.exception;

import org.springframework.http.HttpStatus;

public class WrongDataException extends ApiException {
    public WrongDataException(String message) {
        super(HttpStatus.UNAUTHORIZED, message);
    }
}
