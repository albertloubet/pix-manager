package com.github.albertloubet.pixmanager.repository;

import com.github.albertloubet.pixmanager.model.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}