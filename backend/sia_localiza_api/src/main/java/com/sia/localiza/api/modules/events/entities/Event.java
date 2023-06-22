package com.sia.localiza.api.modules.events.entities;

import java.util.UUID;

import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.UuidGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sia.localiza.api.common.abstractions.DateAudit;
import com.sia.localiza.api.common.annotations.validation.constraints.DayPeriodType;
import com.sia.localiza.api.common.annotations.validation.constraints.DayWeekType;
import com.sia.localiza.api.common.enums.EDayPeriod;
import com.sia.localiza.api.common.enums.EWeekDays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "events")
public class Event extends DateAudit {

    @Id
    @GeneratedValue()
    @UuidGenerator
    private UUID id;

    @Column(name = "summary", nullable = false)
    @NotNull(message = "summary required.")
    @NotBlank(message = "summary required.")
    private String summary;

    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(name = "day_week", nullable = false)
    @Enumerated(EnumType.STRING)
    @NotNull(message = "day_week required.")
    @DayWeekType(anyOf =  {EWeekDays.segunda, EWeekDays.terca, EWeekDays.quarta, EWeekDays.quinta, EWeekDays.sexta, EWeekDays.sabado, EWeekDays.domingo})
    @JsonProperty("day_week")
    @ColumnTransformer(write="?::\"DayWeek\"")
    private EWeekDays dayWeek;

    @Column(name = "day_period", nullable = false)
    @Enumerated(EnumType.STRING)
    @DayPeriodType(anyOf =  {EDayPeriod.manha, EDayPeriod.tarde, EDayPeriod.noite})
    @NotNull(message = "day_period required.")
    @JsonProperty("day_period")
    @ColumnTransformer(write="?::\"DayPeriod\"")
    private EDayPeriod dayPeriod;

    @Column(name = "start_at", nullable = false, columnDefinition = "TIME")
    @JsonProperty("start_at")
    @NotNull(message = "start_at required.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private java.sql.Time startAt;

    @Column(name = "end_at", nullable = false, columnDefinition = "TIME")
    @JsonProperty("end_at")
    @NotNull(message = "end_at required.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private java.sql.Time endAt;

    public Event() {

	}

	public Event(String summary, String description, EWeekDays dayWeek, EDayPeriod dayPeriod, java.sql.Time startAt, java.sql.Time endAt) {
		this.summary = summary;
		this.description = description;
		this.dayWeek = dayWeek;
		this.dayPeriod = dayPeriod;
		this.startAt = startAt;
		this.endAt = endAt;
	}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Enumerated(EnumType.STRING) public EWeekDays getDayWeek() {
        return dayWeek;
    }

    public void setDayWeek(EWeekDays dayWeek) {
        this.dayWeek = dayWeek;
    }

    @Enumerated(EnumType.STRING) public EDayPeriod getDayPeriod() {
        return dayPeriod;
    }

    public void setDayPeriod(EDayPeriod dayPeriod) {
        this.dayPeriod = dayPeriod;
    }

    public java.sql.Time getStartAt() {
        return startAt;
    }

    public void setStartAt(java.sql.Time startAt) {
        this.startAt = startAt;
    }

    public java.sql.Time getEndAt() {
        return endAt;
    }

    public void setEndAt(java.sql.Time endAt) {
        this.endAt = endAt;
    }
}