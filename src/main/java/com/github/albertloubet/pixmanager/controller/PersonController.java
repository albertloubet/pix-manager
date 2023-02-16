package com.github.albertloubet.pixmanager.controller;

import com.github.albertloubet.pixmanager.model.dto.PersonResponseDTO;
import com.github.albertloubet.pixmanager.model.filter.PersonFilter;
import com.github.albertloubet.pixmanager.model.form.PersonRequestForm;
import com.github.albertloubet.pixmanager.model.mapper.PersonMapper;
import com.github.albertloubet.pixmanager.usecase.person.PersonFindByFiltersUsecase;
import com.github.albertloubet.pixmanager.usecase.person.PersonSaveUsecase;
import com.github.albertloubet.pixmanager.usecase.person.PersonUpdateUsecase;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/person")
public class PersonController {

    private final PersonFindByFiltersUsecase personFindByFiltersUsecase;
    private final PersonSaveUsecase personSaveUsecase;
    private final PersonUpdateUsecase personUpdateUsecase;

    @GetMapping
    @Operation(description = "Search all people acording by data in filter")
    public List<PersonResponseDTO> findByFilters(@ParameterObject PersonFilter filter) {
        return personFindByFiltersUsecase.execute(filter);
    }

    @PutMapping("/{personId}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @Operation(description = "Change data of one person")
    public void update(@Parameter(name = "personId", description = "Id where identify one person") @PathVariable Long personId,
                       @RequestBody PersonRequestForm personRequestForm) {
        log.info("Try to change data person with id={}", personId);
        personUpdateUsecase.execute(personId, personRequestForm);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    @Operation(description = "Saves a new person in the environment")
    public PersonResponseDTO create(@RequestBody PersonRequestForm personRequestForm) {
        log.info("Try creating new person with name={}", personRequestForm.name());
        return PersonMapper.INSTANCE.toResponseDTO(personSaveUsecase.execute(personRequestForm));
    }
}