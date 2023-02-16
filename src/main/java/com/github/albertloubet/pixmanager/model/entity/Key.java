package com.github.albertloubet.pixmanager.model.entity;

import com.github.albertloubet.pixmanager.base.BaseEntity;

import com.github.albertloubet.pixmanager.constant.KeyType;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

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
@Table(name = "pix_key")
public class Key extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 6315307606106145749L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idt_pix_key")
    private Long id;

    @Column(name = "des_value")
    private String value;

    @Enumerated(EnumType.STRING)
    @Column(name = "des_type")
    private KeyType type;

    @ManyToOne
    @JoinColumn(name = "idt_account")
    private Account account;
}