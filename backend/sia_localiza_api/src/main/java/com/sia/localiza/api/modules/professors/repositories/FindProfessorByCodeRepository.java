package com.sia.localiza.api.modules.professors.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sia.localiza.api.modules.professors.entities.Professor;


@Component
public class FindProfessorByCodeRepository {
    @Autowired
    private ProfessorRepository professorRepository;
    
    public Professor execute(String name) {
        return this.professorRepository.findByCode(name);
    }
}