package com.sia.localiza.api.modules.professors.controllers;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sia.localiza.api.modules.professors.entities.Professor;
import com.sia.localiza.api.modules.professors.repositories.FindProfessorByIdRepository;
import com.sia.localiza.api.modules.professors.repositories.UpdateProfessorRepository;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@RestController
@Hidden
@RequestMapping("/api/v1/professors/{id}")
public class UpdateProfessorCotroller {

  @Autowired
  private FindProfessorByIdRepository findProfessorByIdRepository;
  @Autowired
  private UpdateProfessorRepository updateProfessorRepository;

  @PutMapping()
  public ResponseEntity<Professor> handle(@PathVariable UUID id, @Valid @RequestBody Professor data) {
    Optional<Professor> professorExists = this.findProfessorByIdRepository.execute(id);
    if(professorExists.isEmpty()) {
      throw new EntityNotFoundException();
    }

    Professor professor = this.updateProfessorRepository.execute(id, data);
    return new ResponseEntity<>(professor, HttpStatus.OK);
  }
}