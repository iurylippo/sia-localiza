package com.sia.localiza.api.modules.subjects.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sia.localiza.api.modules.subjects.entities.Subject;


@Component
public class FindSubjectByCodeRepository {
    @Autowired
    private SubjectRepository subjectRepository;
    
    public Subject execute(String name) {
        return this.subjectRepository.findByCode(name);
    }
}