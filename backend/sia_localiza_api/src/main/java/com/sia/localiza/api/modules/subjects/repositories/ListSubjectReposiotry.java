package com.sia.localiza.api.modules.subjects.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sia.localiza.api.modules.subjects.entities.Subject;


@Component
public class ListSubjectReposiotry {
    @Autowired
    private SubjectRepository subjectRepository;
    
    public List<Subject> execute() {
        return this.subjectRepository.findAll();
    }
}