package com.sia.localiza.api.modules.events.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sia.localiza.api.modules.events.entities.Event;


@Component
public class FindEventBySummaryRepository {
    @Autowired
    private EventRepository eventRepository;
    
    public Event execute(String summary) {
        return this.eventRepository.findBySummary(summary);
    }
}