package com.github.albertloubet.pixmanager.model.dto;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record PersonResponseDTO(
        Long id,
        String uid,
        String name,
        String document,
        String telephone,
        LocalDate birthDate
) { }
