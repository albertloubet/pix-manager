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

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bank")
public class Bank extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 4128676260222046210L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idt_bank")
    private Long id;

    @Column(name = "des_name")
    private String name;

    @Column(name = "des_code")
    private String code;

    @Column(name = "des_cnpj")
    private String cnpj;
}