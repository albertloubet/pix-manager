package com.github.albertloubet.pixmanager.fixture;

import com.github.albertloubet.pixmanager.model.entity.Bank;
import com.github.albertloubet.pixmanager.model.form.BankRequestForm;

public class BankFixture {

    public static BankRequestForm createForm() {
        return BankRequestForm.builder()
                .code("1")
                .name("TEST")
                .cnpj("00000000000000")
                .build();
    }

    public static Bank createEntity() {
        return Bank.builder()
                .id(1L)
                .code("1")
                .name("TEST")
                .cnpj("00000000000000")
                .build();
    }
}
