CREATE TABLE person
(
    idt_person BIGINT NOT NULL AUTO_INCREMENT COMMENT "[PK] Primary Key",
    des_uid TINYTEXT NOT NULL COMMENT "[NOT_SENSITIVE_DATA] Unique hashcode for person",
    des_name VARCHAR(500) NOT NULL COMMENT "[PII] Individual's name",
    des_document VARCHAR(14) NOT NULL COMMENT "[PII] Individual's document",
    des_telephone VARCHAR(11) NOT NULL COMMENT "[PII] Individual's telephone",
    dat_birth_date DATE NOT NULL COMMENT "[PII] Date that person was born",
    dat_created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT "[NOT_SENSITIVE_DATA] Date when this person was inserted",
    dat_updated TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT "[NOT_SENSITIVE_DATA] Date when this person was updated",
    PRIMARY KEY (idt_person)
);

CREATE INDEX person_idx01 ON person (des_name);
CREATE INDEX person_idx02 ON person (des_document);
CREATE INDEX person_idx03 ON person (des_telephone);

CREATE TABLE bank
(
    idt_bank BIGINT NOT NULL AUTO_INCREMENT COMMENT "[PK] Primary Key",
    des_name VARCHAR(500) NOT NULL COMMENT "[NOT_SENSITIVE_DATA] Bank's name",
    des_code VARCHAR(500) NOT NULL COMMENT "[NOT_SENSITIVE_DATA] Bank's number code",
    des_cnpj CHAR(14) NOT NULL COMMENT "[NOT_SENSITIVE_DATA] Bank's document",
    dat_created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT "[NOT_SENSITIVE_DATA] Date when this bank was inserted",
    dat_updated TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT "[NOT_SENSITIVE_DATA] Date when this bank was updated",
    PRIMARY KEY (idt_bank)
);

CREATE INDEX bank_idx01 ON bank (des_name);
CREATE INDEX bank_idx02 ON bank (des_code);

CREATE TABLE account
(
    idt_account BIGINT NOT NULL AUTO_INCREMENT COMMENT "[PK] Primary Key",
    num_account_digit SMALLINT NOT NULL COMMENT "[BANKING_SECRECY] Account's digit",
    num_agency INT NOT NULL COMMENT "[BANKING_SECRECY] Account's agency number",
    num_account BIGINT NOT NULL COMMENT "[BANKING_SECRECY] Account's number",
    idt_bank BIGINT NOT NULL COMMENT "[FK] Account's bank",
    idt_person BIGINT NOT NULL COMMENT "[FK] Account's person",
    dat_created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT "[NOT_SENSITIVE_DATA] Date when this account was inserted",
    dat_updated TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT "[NOT_SENSITIVE_DATA] Date when this account was updated",
    PRIMARY KEY (idt_account)
);

CREATE INDEX account_idx01 ON account (idt_bank, num_account_digit, num_agency, num_account);

ALTER TABLE account ADD CONSTRAINT fk_account_bank FOREIGN KEY (idt_bank) REFERENCES bank(idt_bank);
ALTER TABLE account ADD CONSTRAINT fk_account_person FOREIGN KEY (idt_person) REFERENCES person(idt_person);

CREATE TABLE pix_key
(
    idt_pix_key BIGINT NOT NULL AUTO_INCREMENT COMMENT "[PK] Primary Key",
    des_value VARCHAR(500) NOT NULL COMMENT "[BANKING_SECRECY] Pix's value",
    des_type INT NOT NULL COMMENT "[BANKING_SECRECY] Pix's type",
    idt_account BIGINT NOT NULL COMMENT "[FK] Pix's account",
    dat_created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT "[NOT_SENSITIVE_DATA] Date when this pix key was inserted",
    dat_updated TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT "[NOT_SENSITIVE_DATA] Date when this pix key was updated",
    PRIMARY KEY (idt_pix_key)
);

CREATE INDEX pix_key_idx01 ON pix_key (idt_account);
CREATE INDEX pix_key_idx02 ON pix_key (des_value, des_type, idt_account);

ALTER TABLE pix_key ADD CONSTRAINT fk_pix_key_account FOREIGN KEY (idt_account) REFERENCES account(idt_account);