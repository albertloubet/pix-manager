package com.github.albertloubet.pixmanager.model.mapper;

import com.github.albertloubet.pixmanager.model.dto.BankResponseDTO;
import com.github.albertloubet.pixmanager.model.entity.Bank;
import com.github.albertloubet.pixmanager.model.form.BankRequestForm;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BankMapper {

    BankMapper INSTANCE = Mappers.getMapper(BankMapper.class);

    BankResponseDTO toResponseDTO(Bank bank);

    Bank formToEntity(BankRequestForm bankRequestForm);
}
