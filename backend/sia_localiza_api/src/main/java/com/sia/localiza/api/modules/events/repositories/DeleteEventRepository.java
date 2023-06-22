package com.sia.localiza.api.modules.events.repositories;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class DeleteEventRepository {
    @Autowired
    private EventRepository eventRepository;
    
    public void execute(UUID id) {
       this.eventRepository.deleteById(id);
    }
}