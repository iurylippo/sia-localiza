package com.sia.localiza.api.modules.courses.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sia.localiza.api.common.exceptions.BadRequestException;
import com.sia.localiza.api.modules.courses.entities.Course;
import com.sia.localiza.api.modules.courses.repositories.CreateCourseRepository;
import com.sia.localiza.api.modules.courses.repositories.FindCourseByCodeRepository;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.validation.Valid;

@RestController
@Hidden
@RequestMapping("/api/v1/courses")
public class CreateCourseController {

  @Autowired
  private CreateCourseRepository createCourseRepository;
  @Autowired
  private FindCourseByCodeRepository findCourseByCodeRepository;

  @PostMapping()
  public ResponseEntity<Course> handle(@Valid @RequestBody Course data) {
    Course courseAlredyExists = this.findCourseByCodeRepository.execute(data.getCode());

    if(courseAlredyExists != null) {
       throw new BadRequestException("Course already exists!");
    }
    Course course = this.createCourseRepository.execute(data);
    return new ResponseEntity<>(course, HttpStatus.CREATED);
  }
}