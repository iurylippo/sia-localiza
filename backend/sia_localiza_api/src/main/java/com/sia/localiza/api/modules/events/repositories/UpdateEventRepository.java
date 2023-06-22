package com.sia.localiza.api.modules.events.repositories;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sia.localiza.api.modules.events.entities.Event;


@Component
public class UpdateEventRepository {
    @Autowired
    private EventRepository eventRepository;
    
    public Event execute(UUID id, Event data) {
        data.setId(id);
        return this.eventRepository.save(data);
    }
}