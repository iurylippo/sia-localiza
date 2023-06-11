package com.sia.localiza.api.modules.subjects.repositories;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class DeleteSubjectRepository {
    @Autowired
    private SubjectRepository subjectRepository;
    
    public void execute(UUID id) {
       this.subjectRepository.deleteById(id);
    }
}