package com.github.albertloubet.pixmanager.repository;

import com.github.albertloubet.pixmanager.model.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {
}