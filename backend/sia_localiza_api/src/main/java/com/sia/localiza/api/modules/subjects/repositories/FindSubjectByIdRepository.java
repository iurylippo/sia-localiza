package com.sia.localiza.api.modules.subjects.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sia.localiza.api.modules.subjects.entities.Subject;


@Component
public class FindSubjectByIdRepository {
    @Autowired
    private SubjectRepository subjectRepository;
    
    public Optional<Subject> execute(UUID id) {
        return this.subjectRepository.findById(id);
    }
}