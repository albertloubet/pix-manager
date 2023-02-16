package com.github.albertloubet.pixmanager.exception;

import com.github.albertloubet.pixmanager.constant.ExceptionMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_ACCEPTABLE, reason="Entity Not Found")
public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException() {
        super(ExceptionMessage.ENTITY.getMessage());
    }
}