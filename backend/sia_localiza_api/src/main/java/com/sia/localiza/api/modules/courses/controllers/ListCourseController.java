package com.sia.localiza.api.modules.courses.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sia.localiza.api.modules.courses.entities.Course;
import com.sia.localiza.api.modules.courses.repositories.ListCourseReposiotry;

import io.swagger.v3.oas.annotations.Hidden;

@RestController
@Hidden
@RequestMapping("/api/v1/courses")
public class ListCourseController {

  @Autowired
  private ListCourseReposiotry listCourseReposiotry;

  @GetMapping()
  public ResponseEntity<List<Course>> handle() {
    List<Course>  courses = this.listCourseReposiotry.execute();
    return new ResponseEntity<>(courses, HttpStatus.OK);
  }
}