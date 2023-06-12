package com.sia.localiza.api.modules.subjects.controllers;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sia.localiza.api.modules.subjects.entities.Subject;
import com.sia.localiza.api.modules.subjects.repositories.DeleteSubjectRepository;
import com.sia.localiza.api.modules.subjects.repositories.FindSubjectByIdRepository;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.EntityNotFoundException;

@RestController
@Hidden
@RequestMapping("/api/v1/subjects/{id}")
public class DeleteSubjectController {

  @Autowired
  private FindSubjectByIdRepository findSubjectByIdRepository;
  @Autowired
  private DeleteSubjectRepository deleteSubjectRepository;

  @DeleteMapping()
  public ResponseEntity<Void> handle(@PathVariable UUID id) {
    Optional<Subject> subjectExists = this.findSubjectByIdRepository.execute(id);
    if(subjectExists.isEmpty()) {
      throw new EntityNotFoundException();
    }

    this.deleteSubjectRepository.execute(id);

    return new ResponseEntity<>(HttpStatus.OK);
  }
}