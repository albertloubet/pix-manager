package com.github.albertloubet.pixmanager.repository;

import com.github.albertloubet.pixmanager.model.entity.Key;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeyRepository extends JpaRepository<Key, Long> {
}