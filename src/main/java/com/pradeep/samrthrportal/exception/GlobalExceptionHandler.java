package com.pradeep.samrthrportal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.pradeep.samrthrportal.dto.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<Object>> handleResourceNotFound(ResourceNotFoundException ex) {

        return new ResponseEntity<>(
                new ApiResponse<>(
                    false,
                    HttpStatus.NOT_FOUND.value(),
                    ex.getMessage(),
                    null
            ),
            HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(org.springframework.web.bind.MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Object>> handleValidationException(
            org.springframework.web.bind.MethodArgumentNotValidException ex) {

        String message = ex.getBindingResult()
            .getFieldErrors()
            .stream()
            .map(error -> error.getField() + ": " + error.getDefaultMessage())
            .findFirst()
            .orElse("Validation error");

        return new ResponseEntity<>(
            new ApiResponse<>(
                    false,
                    HttpStatus.BAD_REQUEST.value(),
                    message,
                    null
            ),
            HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(CustomAuthenticationException.class)
    public ResponseEntity<ApiResponse<Object>> handleAuthentication(CustomAuthenticationException ex) {

        return new ResponseEntity<>(
            new ApiResponse<>(
                    false,
                    HttpStatus.UNAUTHORIZED.value(),
                    ex.getMessage(),
                    null
            ),
            HttpStatus.UNAUTHORIZED
        );
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiResponse<Object>> handleBadRequest(BadRequestException ex) {

        return new ResponseEntity<>(
            new ApiResponse<>(
                    false,
                    HttpStatus.BAD_REQUEST.value(),
                    ex.getMessage(),
                    null
            ),
            HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Object>> handleGlobalException(Exception ex) {

        return new ResponseEntity<>(
            new ApiResponse<>(
                    false,
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    ex.getMessage(),
                    null
            ),
            HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}