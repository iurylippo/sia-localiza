package com.sia.localiza.api.modules.courses.controllers;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sia.localiza.api.modules.courses.entities.Course;
import com.sia.localiza.api.modules.courses.repositories.DeleteCourseRepository;
import com.sia.localiza.api.modules.courses.repositories.FindCourseByIdRepository;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.EntityNotFoundException;

@RestController
@Hidden
@RequestMapping("/api/v1/courses/{id}")
public class DeleteCourseController {

  @Autowired
  private FindCourseByIdRepository findCourseByIdRepository;
  @Autowired
  private DeleteCourseRepository deleteCourseRepository;

  @DeleteMapping()
  public ResponseEntity<Void> handle(@PathVariable UUID id) {
    Optional<Course> courseExists = this.findCourseByIdRepository.execute(id);
    if(courseExists.isEmpty()) {
      throw new EntityNotFoundException();
    }

    this.deleteCourseRepository.execute(id);

    return new ResponseEntity<>(HttpStatus.OK);
  }
}