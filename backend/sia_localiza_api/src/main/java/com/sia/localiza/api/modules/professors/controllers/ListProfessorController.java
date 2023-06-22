package com.sia.localiza.api.modules.professors.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sia.localiza.api.modules.professors.entities.Professor;
import com.sia.localiza.api.modules.professors.repositories.ListProfessorReposiotry;

import io.swagger.v3.oas.annotations.Hidden;

@RestController
@Hidden
@RequestMapping("/api/v1/professors")
public class ListProfessorController {

  @Autowired
  private ListProfessorReposiotry listProfessorReposiotry;

  @GetMapping()
  public ResponseEntity<List<Professor>> handle() {
    List<Professor>  professors = this.listProfessorReposiotry.execute();
    return new ResponseEntity<>(professors, HttpStatus.OK);
  }
}