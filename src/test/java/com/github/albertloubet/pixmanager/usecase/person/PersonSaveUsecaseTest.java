package com.github.albertloubet.pixmanager.usecase.person;

import com.github.albertloubet.pixmanager.fixture.PersonFixture;
import com.github.albertloubet.pixmanager.repository.PersonRepository;
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
class PersonSaveUsecaseTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonSaveUsecase personSaveUsecase;

    @Test
    void execute() {
        var entity = PersonFixture.createEntity();
        when(personRepository.save(any())).thenReturn(entity);
        assertEquals(personSaveUsecase.execute(PersonFixture.createForm()), entity);
    }

    @Test
    void executeWithFormNull() {
        try {
            personSaveUsecase.execute(null);
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("personRequestForm is marked non-null but is null"));
        }
    }
}
