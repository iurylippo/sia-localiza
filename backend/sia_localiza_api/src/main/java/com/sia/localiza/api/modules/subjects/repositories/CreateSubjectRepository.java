package com.sia.localiza.api.modules.subjects.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sia.localiza.api.modules.subjects.entities.Subject;


@Component
public class CreateSubjectRepository {
    @Autowired
    private SubjectRepository subjectRepository;
    
    public Subject execute(Subject data) {
        return this.subjectRepository.save(data);
    }
}