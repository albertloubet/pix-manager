package com.github.albertloubet.pixmanager.model.form;

import lombok.Builder;

@Builder
public record BankRequestForm(
        String name,
        String code,
        String cnpj
) { }