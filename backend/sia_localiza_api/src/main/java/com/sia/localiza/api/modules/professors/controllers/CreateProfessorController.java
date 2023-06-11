package com.sia.localiza.api.modules.professors.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sia.localiza.api.common.exceptions.BadRequestException;
import com.sia.localiza.api.modules.professors.entities.Professor;
import com.sia.localiza.api.modules.professors.repositories.CreateProfessorRepository;
import com.sia.localiza.api.modules.professors.repositories.FindProfessorByCodeRepository;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.validation.Valid;

@RestController
@Hidden
@RequestMapping("/api/v1/professors")
public class CreateProfessorController {

  @Autowired
  private CreateProfessorRepository createProfessorRepository;
  @Autowired
  private FindProfessorByCodeRepository findProfessorByCodeRepository;

  @PostMapping()
  public ResponseEntity<Professor> handle(@Valid @RequestBody Professor data) {
    Professor professorAlredyExists = this.findProfessorByCodeRepository.execute(data.getCode());

    if(professorAlredyExists != null) {
       throw new BadRequestException("Professor already exists!");
    }
    Professor professor = this.createProfessorRepository.execute(data);
    return new ResponseEntity<>(professor, HttpStatus.CREATED);
  }
}