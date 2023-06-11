package com.sia.localiza.api.modules.courses.controllers;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sia.localiza.api.modules.courses.entities.Course;
import com.sia.localiza.api.modules.courses.repositories.FindCourseByIdRepository;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.EntityNotFoundException;

@RestController
@Hidden
@RequestMapping("/api/v1/courses/{id}")
public class FindCourseController {

  @Autowired
  private FindCourseByIdRepository findCourseByIdRepository;

  @GetMapping()
  public ResponseEntity<Optional<Course>> handle(@PathVariable UUID id) {
    Optional<Course> course = this.findCourseByIdRepository.execute(id);
    if(course.isEmpty()) {
      throw new EntityNotFoundException();
    }
    return new ResponseEntity<>(course, HttpStatus.OK);
  }
}