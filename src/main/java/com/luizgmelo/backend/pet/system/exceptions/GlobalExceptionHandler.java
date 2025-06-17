package com.luizgmelo.backend.pet.system.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ResponseEntity<List<ExceptionMessage>> inputValidationErrorHandler(MethodArgumentNotValidException exception) {
        var fieldErrors = exception.getFieldErrors();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(fieldErrors.stream().map(ExceptionMessage::new).toList());
    }

}
