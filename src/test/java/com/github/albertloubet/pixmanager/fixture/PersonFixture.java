package com.github.albertloubet.pixmanager.fixture;

import com.github.albertloubet.pixmanager.model.dto.PersonResponseDTO;
import com.github.albertloubet.pixmanager.model.entity.Person;
import com.github.albertloubet.pixmanager.model.filter.PersonFilter;
import com.github.albertloubet.pixmanager.model.form.PersonRequestForm;

import java.time.LocalDate;

public class PersonFixture {

    public static PersonRequestForm createForm() {
        return PersonRequestForm.builder()
                .birthDate(LocalDate.now())
                .name("Teste")
                .document("00000000000")
                .telephone("1199000000")
                .build();
    }

    public static PersonResponseDTO createResponse() {
        return PersonResponseDTO.builder()
                .name("Teste")
                .uid("00000000000")
                .build();
    }

    public static Person createEntity() {
        return Person.builder()
                .id(1L)
                .name("Teste")
                .birthDate(LocalDate.now())
                .document("00000000000")
                .telephone("1199000000")
                .build();
    }

    public static PersonFilter createFilter() {
        return PersonFilter.builder()
                .uid("00000000000")
                .size(10)
                .page(0)
                .build();
    }
}
