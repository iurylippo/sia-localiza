package com.sia.localiza.api.modules.professors.repositories;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class DeleteProfessorRepository {
    @Autowired
    private ProfessorRepository professorRepository;
    
    public void execute(UUID id) {
       this.professorRepository.deleteById(id);
    }
}