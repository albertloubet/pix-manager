package com.github.albertloubet.pixmanager.controller;

import com.github.albertloubet.pixmanager.base.BaseControllerTest;
import com.github.albertloubet.pixmanager.fixture.PersonFixture;
import com.github.albertloubet.pixmanager.usecase.person.PersonFindByFiltersUsecase;
import com.github.albertloubet.pixmanager.usecase.person.PersonSaveUsecase;
import com.github.albertloubet.pixmanager.usecase.person.PersonUpdateUsecase;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class PersonControllerTest extends BaseControllerTest {

    private static final String PATH = "/person";

    @InjectMocks
    private PersonController personController;

    @Mock
    private PersonSaveUsecase personSaveUsecase;

    @Mock
    private PersonUpdateUsecase personUpdateUsecase;

    @Mock
    private PersonFindByFiltersUsecase personFindByFiltersUsecase;

    @BeforeEach
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(personController).build();
    }

    @Test
    @SneakyThrows
    void findByFilters() {
        var filter = PersonFixture.createFilter();
        var response = PersonFixture.createResponse();

        when(personFindByFiltersUsecase.execute(filter)).thenReturn(Collections.singletonList(response));

        mockMvc.perform(get(PATH)
                        .param("page", String.valueOf(filter.getPage()))
                        .param("size", String.valueOf(filter.getSize()))
                        .param("uid", filter.getUid())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(gson.toJson(response)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    void update() {
        var request = PersonFixture.createForm();

        when(personUpdateUsecase.execute(1L, request)).thenReturn(PersonFixture.createResponse());

        mockMvc.perform(put(PATH + "/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(gson.toJson(request)))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    @SneakyThrows
    void create() {
        var request = PersonFixture.createForm();

        when(personSaveUsecase.execute(any())).thenReturn(any());

        mockMvc.perform(post(PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(gson.toJson(request)))
                .andDo(print())
                .andExpect(status().isCreated());
    }
}