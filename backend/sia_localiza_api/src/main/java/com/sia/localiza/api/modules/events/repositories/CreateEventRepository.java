package com.sia.localiza.api.modules.events.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sia.localiza.api.modules.events.entities.Event;


@Component
public class CreateEventRepository {
    @Autowired
    private EventRepository eventRepository;
    
    public Event execute(Event data) {
        Event event = new Event(data.getSummary(), data.getDescription(), data.getDayWeek(), data.getDayPeriod(), data.getEndAt(), data.getEndAt());
 
        return this.eventRepository.save(event);
    }
}