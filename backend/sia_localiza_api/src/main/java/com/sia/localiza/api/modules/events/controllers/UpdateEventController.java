package com.sia.localiza.api.modules.events.controllers;

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

import com.sia.localiza.api.modules.events.entities.Event;
import com.sia.localiza.api.modules.events.repositories.FindEventByIdRepository;
import com.sia.localiza.api.modules.events.repositories.UpdateEventRepository;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@RestController
@Hidden
@RequestMapping("/api/v1/events/{id}")
public class UpdateEventController {

  @Autowired
  private FindEventByIdRepository findEventByIdRepository;
  @Autowired
  private UpdateEventRepository updateEventRepository;

  @PutMapping()
  public ResponseEntity<Event> handle(@PathVariable UUID id, @Valid @RequestBody Event data) {
    Optional<Event> eventExists = this.findEventByIdRepository.execute(id);
    if(eventExists.isEmpty()) {
      throw new EntityNotFoundException();
    }

    Event event = this.updateEventRepository.execute(id, data);
    return new ResponseEntity<>(event, HttpStatus.OK);
  }
}