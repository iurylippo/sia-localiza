package com.sia.localiza.api.modules.events.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sia.localiza.api.modules.events.entities.Event;
import com.sia.localiza.api.modules.events.repositories.CreateEventRepository;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.validation.Valid;


@RestController
@Hidden
@RequestMapping("/api/v1/events")
public class CreateEventController {

  @Autowired
  private CreateEventRepository createEventRepository;

  
  @PostMapping()
  public ResponseEntity<Event> handle(@Valid @RequestBody Event data) {
    // try {
          Event event = this.createEventRepository.execute(data);
      return new ResponseEntity<>(event, HttpStatus.CREATED);
    // } catch (Exception e) {
    //   return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    // }
  }
} 