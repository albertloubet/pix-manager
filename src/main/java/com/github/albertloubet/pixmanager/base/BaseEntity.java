package com.github.albertloubet.pixmanager.base;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 4251388336497281592L;

    @Column(name = "dat_created")
    protected LocalDateTime datCreated;

    @Column(name = "dat_updated")
    protected LocalDateTime datUpdated;

    @PrePersist
    private void prePersist() {
        datCreated = LocalDateTime.now();
        datUpdated = datCreated;
    }

    @PreUpdate
    private void preUpdate() {
        datUpdated = LocalDateTime.now();
    }
}