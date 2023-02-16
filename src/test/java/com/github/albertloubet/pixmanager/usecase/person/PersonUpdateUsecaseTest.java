package com.github.albertloubet.pixmanager.usecase.person;

import com.github.albertloubet.pixmanager.constant.ExceptionMessage;
import com.github.albertloubet.pixmanager.exception.EntityNotFoundException;
import com.github.albertloubet.pixmanager.fixture.PersonFixture;
import com.github.albertloubet.pixmanager.model.mapper.PersonMapper;
import com.github.albertloubet.pixmanager.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PersonUpdateUsecaseTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonUpdateUsecase personUpdateUsecase;

    @Test
    void executeChangeAll() {
        var entity = PersonFixture.createEntity();
        var request = PersonFixture.createForm();

        request.setName("Teste 2");
        request.setDocument("10000000001");
        request.setTelephone("1199000001");
        request.setBirthDate(LocalDate.now());

        when(personRepository.findById(anyLong())).thenReturn(Optional.of(entity));
        when(personRepository.save(any())).thenReturn(PersonMapper.INSTANCE.formToEntity(request));

        var responseDTO = PersonMapper.INSTANCE.toResponseDTO(PersonMapper.INSTANCE.formToEntity(request));

        assertEquals(personUpdateUsecase.execute(entity.getId(), request), responseDTO,
                "These objects didn't match");
    }

    @Test
    void executeChangePartial() {
        var entity = PersonFixture.createEntity();
        var request = PersonFixture.createForm();

        request.setName("Teste 2");
        request.setDocument(null);
        request.setTelephone(null);
        request.setBirthDate(null);

        when(personRepository.findById(anyLong())).thenReturn(Optional.of(entity));
        when(personRepository.save(any())).thenReturn(PersonMapper.INSTANCE.formToEntity(request));

        var responseDTO = PersonMapper.INSTANCE.toResponseDTO(PersonMapper.INSTANCE.formToEntity(request));

        assertEquals(personUpdateUsecase.execute(entity.getId(), request), responseDTO,
                "These objects didn't match");
    }

    @Test
    void executeDoNothing() {
        var entity = PersonFixture.createEntity();
        var request = PersonFixture.createForm();

        request.setName(null);
        request.setDocument(null);
        request.setTelephone(null);
        request.setBirthDate(null);

        when(personRepository.findById(anyLong())).thenReturn(Optional.of(entity));
        when(personRepository.save(any())).thenReturn(entity);

        var responseDTO = PersonMapper.INSTANCE.toResponseDTO(entity);

        assertEquals(personUpdateUsecase.execute(entity.getId(), request), responseDTO,
                "These objects didn't match");
    }

    @Test
    void executeWithEntityNotFoundException() {
        when(personRepository.findById(anyLong())).thenThrow(new EntityNotFoundException());
        var thrown = assertThrows(EntityNotFoundException.class,
                () -> personUpdateUsecase.execute(1L, PersonFixture.createForm()));
        assertTrue(thrown.getMessage().contains(ExceptionMessage.ENTITY.getMessage()));
    }

    @Test
    void executeWithIdNull() {
        try {
            personUpdateUsecase.execute(null, PersonFixture.createForm());
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("id is marked non-null but is null"));
        }
    }

    @Test
    void executeWithFormNull() {
        try {
            personUpdateUsecase.execute(1L, null);
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("personRequestForm is marked non-null but is null"));
        }
    }
}