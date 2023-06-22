package com.sia.localiza.api.modules.events.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sia.localiza.api.common.exceptions.BadRequestException;
import com.sia.localiza.api.modules.events.entities.Event;
import com.sia.localiza.api.modules.events.repositories.CreateEventRepository;
import com.sia.localiza.api.modules.events.repositories.FindEventByUniqueKeys;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.validation.Valid;

@RestController
@Hidden
@RequestMapping("/api/v1/events")
public class CreateEventController {

  @Autowired
  private CreateEventRepository createEventRepository;
  @Autowired
  private FindEventByUniqueKeys findEventByUniqueKeys;


  @PostMapping()
  public ResponseEntity<Event> handle(@Valid @RequestBody Event data) {
    Optional<Event> eventAlredyExists = this.findEventByUniqueKeys.execute(data.getSummary(), data.getDayWeek(), data.getDayPeriod(), data.getStartAt(), data.getEndAt());

    if(eventAlredyExists.isPresent()) {
       throw new BadRequestException("Event already exists!");
    }
    Event event = this.createEventRepository.execute(data);
    return new ResponseEntity<>(event, HttpStatus.CREATED);
  }
}