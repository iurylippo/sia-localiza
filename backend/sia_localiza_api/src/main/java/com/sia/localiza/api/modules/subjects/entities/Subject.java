package com.sia.localiza.api.modules.subjects.entities;

import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sia.localiza.api.common.abstractions.DateAudit;
import com.sia.localiza.api.common.annotations.validation.constraints.UUIDType;
import com.sia.localiza.api.modules.courses.entities.Course;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "subjects")
@JsonIgnoreProperties(value = { "couseId" })
public class Subject extends DateAudit {

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

    @Column()
    @JsonProperty("course_id")
    @UUIDType
    @NotNull(message = "course_id required.")
    private UUID courseId;

    @ManyToOne
    @JoinColumn(name = "courseId", insertable=false, updatable=false)
    private Course course;

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
    
    public UUID getCouseId() {
        return courseId;
    }

    public void setCouseId(UUID couseId) {
        this.courseId = couseId;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}