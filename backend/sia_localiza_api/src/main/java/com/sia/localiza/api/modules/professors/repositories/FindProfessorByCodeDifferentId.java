package com.sia.localiza.api.modules.professors.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sia.localiza.api.modules.professors.entities.Professor;


@Component
public class FindProfessorByCodeDifferentId {
    @Autowired
    private ProfessorRepository professorRepository;
    
    public Optional<Professor> execute(String code, UUID id) {
       return this.professorRepository.findByCodeAndIdNot(code, id);
    }
}
