package com.sia.localiza.api.modules.events.controllers;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sia.localiza.api.modules.events.entities.Event;
import com.sia.localiza.api.modules.events.repositories.FindEventByIdRepository;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.EntityNotFoundException;

@RestController
@Hidden
@RequestMapping("/api/v1/events/{id}")
public class FindEventController {

  @Autowired
  private FindEventByIdRepository findEventByIdRepository;

  @GetMapping()
  public ResponseEntity<Optional<Event>> handle(@PathVariable UUID id) {
    Optional<Event> event = this.findEventByIdRepository.execute(id);
    if(event.isEmpty()) {
      throw new EntityNotFoundException();
    }
    return new ResponseEntity<>(event, HttpStatus.OK);
  }
}