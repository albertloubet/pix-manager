package com.github.albertloubet.pixmanager.model.entity;

import com.github.albertloubet.pixmanager.base.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.io.Serial;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "person")
public class Person extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 7317664301737544549L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idt_person")
    private Long id;

    @Column(name = "des_uid")
    private String uid;

    @Column(name = "des_name")
    private String name;

    @Column(name = "des_document")
    private String document;

    @Column(name = "des_telephone")
    private String telephone;

    @Column(name = "dat_birth_date")
    private LocalDate birthDate;
}
