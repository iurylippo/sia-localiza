package com.sia.localiza.api.modules.events.controllers;

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
import com.sia.localiza.api.modules.events.repositories.FindEventBySummaryRepository;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.validation.Valid;

@RestController
@Hidden
@RequestMapping("/api/v1/events")
public class CreateEventController {

  @Autowired
  private CreateEventRepository createEventRepository;
  @Autowired
  private FindEventBySummaryRepository findEventBySummaryRepository;

  @PostMapping()
  public ResponseEntity<Event> handle(@Valid @RequestBody Event data) {
    Event eventAlredyExists = this.findEventBySummaryRepository.execute(data.getSummary());

    if(eventAlredyExists != null) {
       throw new BadRequestException("Event already exists!");
    }
    Event event = this.createEventRepository.execute(data);
    return new ResponseEntity<>(event, HttpStatus.CREATED);
  }
}