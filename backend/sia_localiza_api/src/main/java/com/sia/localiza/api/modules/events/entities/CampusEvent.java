package com.sia.localiza.api.modules.events.entities;

import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sia.localiza.api.common.abstractions.DateAudit;
import com.sia.localiza.api.common.annotations.validation.constraints.UUIDType;
import com.sia.localiza.api.modules.professors.entities.Professor;
import com.sia.localiza.api.modules.subjects.entities.Subject;

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
@Table(name = "campus_events")
@JsonIgnoreProperties(value = { "eventId", "professorId", "subjectId" })
public class CampusEvent extends DateAudit {

    @Id
    @GeneratedValue()
    @UuidGenerator
    private UUID id;

    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column()
    @JsonProperty("event_id")
    @UUIDType
    @NotNull(message = "event_id required.")
    private UUID eventId;

    @ManyToOne
    @JoinColumn(name = "eventId", insertable=false, updatable=false)
    private Event event;

    @Column()
    @JsonProperty("professor_id")
    @UUIDType
    @NotNull(message = "professor_id required.")
    private UUID professorId;

    @ManyToOne
    @JoinColumn(name = "professorId", insertable=false, updatable=false)
    private Professor professor;

    @Column()
    @JsonProperty("subject_id")
    @UUIDType
    @NotNull(message = "subject_id required.")
    private UUID subjectId;

    @ManyToOne
    @JoinColumn(name = "subjectId", insertable=false, updatable=false)
    private Subject subject;

    @Column(name = "class", nullable = false)
    @NotNull(message = "class required.")
    @NotBlank(message = "class required.")
    @JsonProperty("class")
    private String className;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UUID getEventId() {
        return eventId;
    }

    public void setEventId(UUID eventId) {
        this.eventId = eventId;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public UUID getProfessorId() {
        return professorId;
    }

    public void setProfessorId(UUID professorId) {
        this.professorId = professorId;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public UUID getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(UUID subjectId) {
        this.subjectId = subjectId;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

}