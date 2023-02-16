package com.github.albertloubet.pixmanager.controller;

import com.github.albertloubet.pixmanager.base.BaseControllerTest;
import com.github.albertloubet.pixmanager.fixture.BankFixture;
import com.github.albertloubet.pixmanager.usecase.bank.BankSaveUsecase;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.http.MediaType;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class BankControllerTest extends BaseControllerTest {

    private static final String PATH = "/bank";

    @InjectMocks
    private BankController bankController;

    @Mock
    private BankSaveUsecase bankSaveUsecase;

    @BeforeEach
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(bankController).build();
    }

    @Test
    @SneakyThrows
    void create() {
        var request = BankFixture.createForm();

        when(bankSaveUsecase.execute(any())).thenReturn(any());

        mockMvc.perform(post(PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(gson.toJson(request)))
                .andDo(print())
                .andExpect(status().isCreated());
    }
}
