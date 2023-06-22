package com.sia.localiza.api.modules.events.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sia.localiza.api.modules.events.entities.Event;


@Component
public class FindEventByIdRepository {
    @Autowired
    private EventRepository eventRepository;
    
    public Optional<Event> execute(UUID id) {
        return this.eventRepository.findById(id);
    }
}