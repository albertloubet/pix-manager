package com.github.albertloubet.pixmanager.model.form;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record PersonRequestForm(
        String name,
        String document,
        String telephone,
        LocalDate birthDate
) { }