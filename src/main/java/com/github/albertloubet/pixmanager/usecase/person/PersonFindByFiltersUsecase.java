package com.github.albertloubet.pixmanager.usecase.person;

import com.github.albertloubet.pixmanager.model.dto.PersonResponseDTO;
import com.github.albertloubet.pixmanager.model.filter.PersonFilter;
import com.github.albertloubet.pixmanager.model.mapper.PersonMapper;
import com.github.albertloubet.pixmanager.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PersonFindByFiltersUsecase {

    private final PersonRepository personRepository;

    public List<PersonResponseDTO> execute(PersonFilter filter) {
        var person = PersonMapper.INSTANCE.filterToEntity(filter);
        var fieldSort = Sort.by(Sort.Direction.DESC, "name", "datCreated");
        var people = personRepository.findAll(Example.of(person),
                PageRequest.of(filter.page(),
                        filter.size(),
                        fieldSort));

        return PersonMapper.INSTANCE.entitiesToResponse(people.getContent());
    }
}
