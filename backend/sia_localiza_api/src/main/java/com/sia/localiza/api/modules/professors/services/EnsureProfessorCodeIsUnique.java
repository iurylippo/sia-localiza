package com.sia.localiza.api.modules.professors.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sia.localiza.api.common.exceptions.BadRequestException;
import com.sia.localiza.api.modules.professors.entities.Professor;
import com.sia.localiza.api.modules.professors.repositories.FindProfessorByCodeDifferentId;

@Service
public class EnsureProfessorCodeIsUnique {
    @Autowired
    private FindProfessorByCodeDifferentId findProfessorByCodeDifferentId;

    public void execute(String code, UUID id) {
        Optional<Professor> alraedyTaken = this.findProfessorByCodeDifferentId.execute(code, id);
        
        if(!alraedyTaken.isEmpty()) {
            throw new BadRequestException("Code: "+ code + ", Already taken!");
        }
    }
}
