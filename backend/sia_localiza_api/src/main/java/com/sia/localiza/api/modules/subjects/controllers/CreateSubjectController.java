package com.sia.localiza.api.modules.subjects.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sia.localiza.api.common.exceptions.BadRequestException;
import com.sia.localiza.api.modules.subjects.entities.Subject;
import com.sia.localiza.api.modules.subjects.repositories.CreateSubjectRepository;
import com.sia.localiza.api.modules.subjects.repositories.FindSubjectByCodeRepository;
import com.sia.localiza.api.modules.subjects.services.EnsureSubjectRelationsExists;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.validation.Valid;

@RestController
@Hidden
@RequestMapping("/api/v1/subjects")
public class CreateSubjectController {

  @Autowired
  private CreateSubjectRepository createSubjectRepository;
  @Autowired
  private FindSubjectByCodeRepository findSubjectByCodeRepository;
  @Autowired
  private EnsureSubjectRelationsExists ensureSubjectRelationsExists;
  

  @PostMapping()
  public ResponseEntity<Subject> handle(@Valid @RequestBody Subject data) {
    this.ensureSubjectRelationsExists.execute(data);
    
    Subject subjectAlredyExists = this.findSubjectByCodeRepository.execute(data.getCode());

    if(subjectAlredyExists != null) {
       throw new BadRequestException("Subject already exists!");
    }
    Subject subject = this.createSubjectRepository.execute(data);
    return new ResponseEntity<>(subject, HttpStatus.CREATED);
  }
}