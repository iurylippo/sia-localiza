package com.sia.localiza.api.modules.professors.entities;

import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import com.sia.localiza.api.common.abstractions.DateAudit;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "professors")
public class Professor extends DateAudit {

    @Id
    @GeneratedValue()
    @UuidGenerator
    private UUID id;

    @Column(name = "code", nullable = false)
    @NotNull(message = "code required.")
    @NotBlank(message = "code required.")
    private String code;

    @Column(name = "name", nullable = false)
    @NotNull(message = "name required.")
    @NotBlank(message = "name required.")
    private String name;

    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}