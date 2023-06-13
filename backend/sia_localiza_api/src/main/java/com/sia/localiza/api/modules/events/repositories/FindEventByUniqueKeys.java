package com.sia.localiza.api.modules.events.repositories;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sia.localiza.api.common.enums.EDayPeriod;
import com.sia.localiza.api.common.enums.EWeekDays;
import com.sia.localiza.api.modules.events.entities.Event;


@Component
public class FindEventByUniqueKeys {
    @Autowired
    private EventRepository eventRepository;
    
    public Optional<Event> execute(String summary, EWeekDays dayWeek, EDayPeriod dayPeriod, java.sql.Time startAt, java.sql.Time endAt) {
        return this.eventRepository.findByUniqueKey(summary, dayWeek.toString(), dayPeriod.toString(), startAt.toString(), endAt.toString());
    }
}