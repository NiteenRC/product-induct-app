package com.nc.exception;

import com.nc.response.HttpResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CreationException.class)
    public ResponseEntity<HttpResponse> handleBrandCreationException(CreationException ex) {
        HttpResponse response = new HttpResponse("error", null, ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<HttpResponse> handleBrandConflictException(ConflictException ex) {
        HttpResponse response = new HttpResponse("conflict", null, ex.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }
}

