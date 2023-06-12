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

import com.sia.localiza.api.modules.events.entities.CampusEvent;
import com.sia.localiza.api.modules.events.repositories.FindCampusEventByIdRepository;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.EntityNotFoundException;

@RestController
@Hidden
@RequestMapping("/api/v1/events/campus/{id}")
public class FindCampusEventController {

  @Autowired
  private FindCampusEventByIdRepository findCampusEventByIdRepository;

  @GetMapping()
  public ResponseEntity<Optional<CampusEvent>> handle(@PathVariable UUID id) {
    Optional<CampusEvent> event = this.findCampusEventByIdRepository.execute(id);
    if(event.isEmpty()) {
      throw new EntityNotFoundException();
    }
    return new ResponseEntity<>(event, HttpStatus.OK);
  }
}