package com.sia.localiza.api.modules.courses.controllers;

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

import com.sia.localiza.api.modules.courses.entities.Course;
import com.sia.localiza.api.modules.courses.repositories.FindCourseByIdRepository;
import com.sia.localiza.api.modules.courses.repositories.UpdateCourseRepository;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@RestController
@Hidden
@RequestMapping("/api/v1/courses/{id}")
public class UpdateCourseCotroller {

  @Autowired
  private FindCourseByIdRepository findCourseByIdRepository;
  @Autowired
  private UpdateCourseRepository updateCourseRepository;

  @PutMapping()
  public ResponseEntity<Course> handle(@PathVariable UUID id, @Valid @RequestBody Course data) {
    Optional<Course> courseExists = this.findCourseByIdRepository.execute(id);
    if(courseExists.isEmpty()) {
      throw new EntityNotFoundException();
    }

    Course course = this.updateCourseRepository.execute(id, data);
    return new ResponseEntity<>(course, HttpStatus.OK);
  }
}