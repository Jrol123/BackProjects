package com.example.project.exception;

import com.example.project.dto.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ErrorResponseDto> handleCreationException(
            ApiException exception
    ) {
        var error = ErrorDto.builder()
                .message(exception.getMessage())
                .build();

        var result = new ErrorResponseDto().setError(error);

        return ResponseEntity
                .status(exception.getHttpStatus())
                .body(result);
    }

}