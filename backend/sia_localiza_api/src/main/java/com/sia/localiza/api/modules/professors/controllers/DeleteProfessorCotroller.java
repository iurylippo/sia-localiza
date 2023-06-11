package com.sia.localiza.api.modules.professors.controllers;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sia.localiza.api.modules.professors.entities.Professor;
import com.sia.localiza.api.modules.professors.repositories.DeleteProfessorRepository;
import com.sia.localiza.api.modules.professors.repositories.FindProfessorByIdRepository;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.EntityNotFoundException;

@RestController
@Hidden
@RequestMapping("/api/v1/professors/{id}")
public class DeleteProfessorCotroller {

  @Autowired
  private FindProfessorByIdRepository findProfessorByIdRepository;
  @Autowired
  private DeleteProfessorRepository deleteProfessorRepository;

  @DeleteMapping()
  public ResponseEntity<Void> handle(@PathVariable UUID id) {
    Optional<Professor> eventExists = this.findProfessorByIdRepository.execute(id);
    if(eventExists.isEmpty()) {
      throw new EntityNotFoundException();
    }

    this.deleteProfessorRepository.execute(id);

    return new ResponseEntity<>(HttpStatus.OK);
  }
}