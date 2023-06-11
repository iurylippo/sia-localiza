package com.sia.localiza.api.modules.professors.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sia.localiza.api.modules.professors.entities.Professor;


@Component
public class CreateProfessorRepository {
    @Autowired
    private ProfessorRepository professorRepository;
    
    public Professor execute(Professor data) {
        return this.professorRepository.save(data);
    }
}