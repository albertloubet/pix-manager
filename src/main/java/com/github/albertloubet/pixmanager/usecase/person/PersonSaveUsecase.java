package com.github.albertloubet.pixmanager.usecase.person;

import com.github.albertloubet.pixmanager.model.entity.Person;
import com.github.albertloubet.pixmanager.model.form.PersonRequestForm;
import com.github.albertloubet.pixmanager.model.mapper.PersonMapper;
import com.github.albertloubet.pixmanager.repository.PersonRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class PersonSaveUsecase {

    private final PersonRepository personRepository;

    private String generateRandomUID() {
        return "PERSON:" + UUID.randomUUID()
                .toString()
                .toUpperCase()
                .replace("-", StringUtils.EMPTY);
    }

    public Person execute(@NonNull PersonRequestForm personRequestForm) {
        var person = PersonMapper.INSTANCE.formToEntity(personRequestForm);
        person.setUid(generateRandomUID());
        return personRepository.save(person);
    }
}
