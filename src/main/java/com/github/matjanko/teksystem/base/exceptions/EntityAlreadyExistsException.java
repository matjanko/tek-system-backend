package com.github.matjanko.teksystem.base.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class EntityAlreadyExistsException extends RuntimeException {

    public EntityAlreadyExistsException() {
        super("Entity already exists");
    }

    public EntityAlreadyExistsException(String message) {
        super(message);
    }
}
