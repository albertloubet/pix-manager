package com.github.albertloubet.pixmanager.model.dto;

import lombok.Builder;

@Builder
public record BankResponseDTO(
        Long id,
        String name,
        String code,
        String cnpj
) { }