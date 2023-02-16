package com.github.albertloubet.pixmanager.usecase.bank;

import com.github.albertloubet.pixmanager.model.entity.Bank;
import com.github.albertloubet.pixmanager.model.form.BankRequestForm;
import com.github.albertloubet.pixmanager.model.mapper.BankMapper;
import com.github.albertloubet.pixmanager.repository.BankRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BankSaveUsecase {

    private final BankRepository bankRepository;

    public Bank execute(@NonNull BankRequestForm bankRequestForm) {
        return bankRepository.save(BankMapper.INSTANCE.formToEntity(bankRequestForm));
    }
}
