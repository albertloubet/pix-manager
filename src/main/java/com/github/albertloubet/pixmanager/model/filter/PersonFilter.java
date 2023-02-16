package com.github.albertloubet.pixmanager.model.filter;

import io.swagger.v3.oas.annotations.Parameter;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record PersonFilter(
        String uid,
        String name,
        String document,
        String telephone,
        LocalDate birthDate,
        @Parameter(required = true, example = "0")
        Integer page,
        @Parameter(required = true, example = "10")
        Integer size
) { }