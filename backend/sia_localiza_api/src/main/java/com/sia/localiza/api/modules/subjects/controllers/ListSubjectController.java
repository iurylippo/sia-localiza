package com.sia.localiza.api.modules.subjects.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sia.localiza.api.modules.subjects.entities.Subject;
import com.sia.localiza.api.modules.subjects.repositories.ListSubjectReposiotry;

import io.swagger.v3.oas.annotations.Hidden;

@RestController
@Hidden
@RequestMapping("/api/v1/subjects")
public class ListSubjectController {

  @Autowired
  private ListSubjectReposiotry listSubjectReposiotry;

  @GetMapping()
  public ResponseEntity<List<Subject>> handle() {
    List<Subject> subjects = this.listSubjectReposiotry.execute();
    return new ResponseEntity<>(subjects, HttpStatus.OK);
  }
}