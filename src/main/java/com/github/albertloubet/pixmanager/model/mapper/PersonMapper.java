package com.github.albertloubet.pixmanager.model.mapper;

import com.github.albertloubet.pixmanager.model.dto.PersonResponseDTO;
import com.github.albertloubet.pixmanager.model.entity.Person;
import com.github.albertloubet.pixmanager.model.filter.PersonFilter;
import com.github.albertloubet.pixmanager.model.form.PersonRequestForm;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    PersonResponseDTO toResponseDTO(Person person);

    Person formToEntity(PersonRequestForm personRequestForm);

    Person filterToEntity(PersonFilter personFilter);

    List<PersonResponseDTO> entitiesToResponse(List<Person> people);
}
