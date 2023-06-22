package com.sia.localiza.api.modules.events.repositories;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sia.localiza.api.modules.events.entities.CampusEvent;

@Component
public class UpdateCampusEventRepository {
    @Autowired
    private CampusEventRepository campusEventRepository;
    
    public CampusEvent execute(UUID id, CampusEvent data) {
        data.setId(id);
        return this.campusEventRepository.save(data);
    }
}