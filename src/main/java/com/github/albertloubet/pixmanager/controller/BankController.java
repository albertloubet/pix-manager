package com.github.albertloubet.pixmanager.controller;

import com.github.albertloubet.pixmanager.model.dto.BankResponseDTO;
import com.github.albertloubet.pixmanager.model.form.BankRequestForm;
import com.github.albertloubet.pixmanager.model.mapper.BankMapper;
import com.github.albertloubet.pixmanager.usecase.bank.BankSaveUsecase;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestBody;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/bank")
public class BankController {

    private final BankSaveUsecase bankSaveUsecase;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    @Operation(description = "Saves a new bank in the environment")
    public BankResponseDTO create(@RequestBody BankRequestForm bankRequestForm) {
        log.info("Try creating new bank with name={}", bankRequestForm.name());
        return BankMapper.INSTANCE.toResponseDTO(bankSaveUsecase.execute(bankRequestForm));
    }
}