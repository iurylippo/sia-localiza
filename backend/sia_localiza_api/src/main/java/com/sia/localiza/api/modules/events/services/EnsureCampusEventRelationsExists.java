package com.sia.localiza.api.modules.events.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sia.localiza.api.common.exceptions.BadRequestException;
import com.sia.localiza.api.modules.events.entities.CampusEvent;
import com.sia.localiza.api.modules.events.entities.Event;
import com.sia.localiza.api.modules.events.repositories.FindEventByIdRepository;
import com.sia.localiza.api.modules.professors.entities.Professor;
import com.sia.localiza.api.modules.professors.repositories.FindProfessorByIdRepository;
import com.sia.localiza.api.modules.subjects.entities.Subject;
import com.sia.localiza.api.modules.subjects.repositories.FindSubjectByIdRepository;

@Service
public class EnsureCampusEventRelationsExists {
    @Autowired
    private FindEventByIdRepository findEventByIdRepository;
    @Autowired
    private FindProfessorByIdRepository findProfessorByIdRepository;
    @Autowired
    private FindSubjectByIdRepository findSubjectByIdRepository;
   

    public void execute(CampusEvent campusEvent) {
        Optional<Event> eventExists = this.findEventByIdRepository.execute(campusEvent.getEventId());
        
        if(eventExists.isEmpty()) {
            throw new BadRequestException("Event does not exists!");
        }    

        Optional<Professor> professorExists = this.findProfessorByIdRepository.execute(campusEvent.getProfessorId());
        
        if(professorExists.isEmpty()) {
            throw new BadRequestException("Professor does not exists!");
        }    

        Optional<Subject> subjectExists = this.findSubjectByIdRepository.execute(campusEvent.getSubjectId());
        
        if(subjectExists.isEmpty()) {
            throw new BadRequestException("Subject does not exists!");
        }    
    }
}
