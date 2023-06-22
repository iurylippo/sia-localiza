package com.sia.localiza.api.modules.subjects.repositories;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sia.localiza.api.modules.subjects.entities.Subject;


@Component
public class UpdateSubjectRepository {
    @Autowired
    private SubjectRepository subjectRepository;
    
    public Subject execute(UUID id, Subject data) {
        data.setId(id);
        return this.subjectRepository.save(data);
    }
}