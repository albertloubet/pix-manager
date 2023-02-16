package com.github.albertloubet.pixmanager.usecase.bank;

import com.github.albertloubet.pixmanager.fixture.BankFixture;
import com.github.albertloubet.pixmanager.repository.BankRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BankSaveUsecaseTest {

    @Mock
    private BankRepository bankRepository;

    @InjectMocks
    private BankSaveUsecase bankSaveUsecase;

    @Test
    void execute() {
        var entity = BankFixture.createEntity();
        when(bankRepository.save(any())).thenReturn(entity);
        assertEquals(bankSaveUsecase.execute(BankFixture.createForm()), entity);
    }

    @Test
    void executeWithFormNull() {
        try {
            bankSaveUsecase.execute(null);
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("bankRequestForm is marked non-null but is null"));
        }
    }
}
