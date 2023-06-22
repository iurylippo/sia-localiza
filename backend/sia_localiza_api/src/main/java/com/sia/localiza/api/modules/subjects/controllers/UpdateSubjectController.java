package com.sia.localiza.api.modules.subjects.controllers;

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

import com.sia.localiza.api.modules.subjects.entities.Subject;
import com.sia.localiza.api.modules.subjects.repositories.FindSubjectByIdRepository;
import com.sia.localiza.api.modules.subjects.repositories.UpdateSubjectRepository;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@RestController
@Hidden
@RequestMapping("/api/v1/subjects/{id}")
public class UpdateSubjectController {

  @Autowired
  private FindSubjectByIdRepository findSubjectByIdRepository;
  @Autowired
  private UpdateSubjectRepository updateSubjectRepository;

  @PutMapping()
  public ResponseEntity<Subject> handle(@PathVariable UUID id, @Valid @RequestBody Subject data) {
    Optional<Subject> subjectExists = this.findSubjectByIdRepository.execute(id);
    if(subjectExists.isEmpty()) {
      throw new EntityNotFoundException();
    }

    Subject subject = this.updateSubjectRepository.execute(id, data);
    return new ResponseEntity<>(subject, HttpStatus.OK);
  }
}