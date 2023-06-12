package com.sia.localiza.api.modules.events.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sia.localiza.api.modules.events.entities.CampusEvent;


@Component
public class ListCampusEventReposiotry {
    @Autowired
    private CampusEventRepository campusEventRepository;
    
    public List<CampusEvent> execute() {
        return this.campusEventRepository.findAll();
    }
}