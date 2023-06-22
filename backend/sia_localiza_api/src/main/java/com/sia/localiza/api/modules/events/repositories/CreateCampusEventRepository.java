package com.sia.localiza.api.modules.events.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sia.localiza.api.modules.events.entities.CampusEvent;


@Component
public class CreateCampusEventRepository {
    @Autowired
    private CampusEventRepository campusEventRepository;
    
    public CampusEvent execute(CampusEvent data) {
        return this.campusEventRepository.save(data);
    }
}