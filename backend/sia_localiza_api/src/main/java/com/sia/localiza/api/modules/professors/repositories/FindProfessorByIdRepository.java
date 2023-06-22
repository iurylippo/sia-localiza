package com.sia.localiza.api.modules.professors.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sia.localiza.api.modules.professors.entities.Professor;


@Component
public class FindProfessorByIdRepository {
    @Autowired
    private ProfessorRepository professorRepository;
    
    public Optional<Professor> execute(UUID id) {
        return this.professorRepository.findById(id);
    }
}