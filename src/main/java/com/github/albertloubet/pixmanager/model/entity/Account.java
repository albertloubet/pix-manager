package com.github.albertloubet.pixmanager.model.entity;

import com.github.albertloubet.pixmanager.base.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
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
@Table(name = "account")
public class Account extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 6036846382187263621L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idt_account")
    protected Long id;

    @Column(name = "num_account_digit")
    private Integer accountDigit;

    @Column(name = "num_agency")
    private Integer agencyNumber;

    @Column(name = "num_account")
    private Long accountNumber;

    @ManyToOne
    @JoinColumn(name = "idt_bank")
    private Bank bank;

    @ManyToOne
    @JoinColumn(name = "idt_person")
    private Person person;
}