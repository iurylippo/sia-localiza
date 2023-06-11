package com.sia.localiza.api.modules.professors.repositories;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sia.localiza.api.modules.professors.entities.Professor;


@Component
public class UpdateProfessorRepository {
    @Autowired
    private ProfessorRepository professorRepository;
    
    public Professor execute(UUID id, Professor data) {
        data.setId(id);
        return this.professorRepository.save(data);
    }
}