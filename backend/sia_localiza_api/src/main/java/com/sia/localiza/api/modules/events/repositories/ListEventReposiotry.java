package com.sia.localiza.api.modules.events.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sia.localiza.api.modules.events.entities.Event;


@Component
public class ListEventReposiotry {
    @Autowired
    private EventRepository eventRepository;
    
    public List<Event> execute() {
        return this.eventRepository.findAll();
    }
}