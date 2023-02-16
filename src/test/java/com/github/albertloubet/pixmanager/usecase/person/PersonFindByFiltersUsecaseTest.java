package com.github.albertloubet.pixmanager.usecase.person;

import com.github.albertloubet.pixmanager.fixture.PersonFixture;
import com.github.albertloubet.pixmanager.model.mapper.PersonMapper;
import com.github.albertloubet.pixmanager.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PersonFindByFiltersUsecaseTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonFindByFiltersUsecase personFindByFiltersUsecase;

    private static final Sort SORT = Sort.by(Sort.Direction.DESC, "name", "datCreated");

    @Test
    void execute() {
        var filter = PersonFixture.createFilter();
        when(personRepository.findAll(
                Example.of(PersonMapper.INSTANCE.filterToEntity(filter)),
                PageRequest.of(filter.getPage(), filter.getSize(), SORT)
        )).thenReturn(new PageImpl<>(Collections.singletonList(PersonFixture.createEntity())));
        assertNotNull(personFindByFiltersUsecase.execute(filter), "This object should not be null");
    }
}
