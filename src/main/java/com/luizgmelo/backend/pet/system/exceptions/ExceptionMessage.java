package com.luizgmelo.backend.pet.system.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

public record ExceptionMessage(HttpStatus status, String message) {
    public ExceptionMessage(FieldError fieldError) {
        this(HttpStatus.BAD_REQUEST, fieldError.getDefaultMessage());
    }
}
