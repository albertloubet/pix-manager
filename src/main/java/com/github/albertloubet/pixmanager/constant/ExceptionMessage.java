package com.github.albertloubet.pixmanager.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionMessage {
    ENTITY("Not is possible to find required entity");

    private String message;
}
