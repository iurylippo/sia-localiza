package com.sia.localiza.api.modules.professors.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sia.localiza.api.modules.professors.entities.Professor;


@Component
public class ListProfessorReposiotry {
    @Autowired
    private ProfessorRepository professorRepository;
    
    public List<Professor> execute() {
        return this.professorRepository.findAll();
    }
}