package com.github.albertloubet.pixmanager.usecase.person;

import com.github.albertloubet.pixmanager.exception.EntityNotFoundException;
import com.github.albertloubet.pixmanager.model.dto.PersonResponseDTO;
import com.github.albertloubet.pixmanager.model.entity.Person;
import com.github.albertloubet.pixmanager.model.form.PersonRequestForm;
import com.github.albertloubet.pixmanager.model.mapper.PersonMapper;
import com.github.albertloubet.pixmanager.repository.PersonRepository;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Slf4j
@Component
@RequiredArgsConstructor
public class PersonUpdateUsecase {

    private final PersonRepository personRepository;

    private Person validateFields(Person person, PersonRequestForm personRequestForm) {
        if (StringUtils.isNotEmpty(personRequestForm.name())) {
            log.info("Change oldName={} to newName={}", person.getName(), personRequestForm.name());
            person.setName(personRequestForm.name());
        }

        if (StringUtils.isNotEmpty(personRequestForm.document())) {
            log.info("Change oldDocument={} to newDocument={}", person.getDocument(), personRequestForm.document());
            person.setDocument(personRequestForm.document());
        }

        if (StringUtils.isNotEmpty(personRequestForm.telephone())) {
            log.info("Change oldTelephone={} to newTelephone={}", person.getTelephone(), personRequestForm.telephone());
            person.setTelephone(personRequestForm.telephone());
        }

        if (Objects.nonNull(personRequestForm.birthDate())) {
            log.info("Change oldBirthDate={} to newBirthDate={}", person.getBirthDate(), personRequestForm.birthDate());
            person.setBirthDate(personRequestForm.birthDate());
        }

        return person;
    }

    public PersonResponseDTO execute(@NonNull Long id, @NonNull PersonRequestForm personRequestForm) {
        var person = personRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        var personChanged = personRepository.save(validateFields(person, personRequestForm));

        log.info("Process to update person data with id={} was finished with sucess", id);

        return PersonMapper.INSTANCE.toResponseDTO(personChanged);
    }
}
