package com.sia.localiza.api.modules.events.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sia.localiza.api.modules.events.entities.CampusEvent;


@Component
public class FindCampusEventByIdRepository {
    @Autowired
    private CampusEventRepository campusEventRepository;
    
    public Optional<CampusEvent> execute(UUID id) {
        return this.campusEventRepository.findById(id);
    }
}