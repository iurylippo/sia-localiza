package com.sia.localiza.api.modules.events.repositories;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class DeleteCampusEventRepository {
    @Autowired
    private CampusEventRepository campusEventRepository;
    
    public void execute(UUID id) {
       this.campusEventRepository.deleteById(id);
    }
}