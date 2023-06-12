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

import com.sia.localiza.api.modules.events.entities.CampusEvent;
import com.sia.localiza.api.modules.events.repositories.FindCampusEventByIdRepository;
import com.sia.localiza.api.modules.events.repositories.UpdateCampusEventRepository;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@RestController
@Hidden
@RequestMapping("/api/v1/events/campus/{id}")
public class UpdateCampusEventController {

  @Autowired
  private FindCampusEventByIdRepository findCampusEventByIdRepository;
  @Autowired
  private UpdateCampusEventRepository updateCampusEventRepository;

  @PutMapping()
  public ResponseEntity<CampusEvent> handle(@PathVariable UUID id, @Valid @RequestBody CampusEvent data) {
    Optional<CampusEvent> campusEventExists = this.findCampusEventByIdRepository.execute(id);
    if(campusEventExists.isEmpty()) {
      throw new EntityNotFoundException();
    }

    CampusEvent campusEvent = this.updateCampusEventRepository.execute(id, data);
    return new ResponseEntity<>(campusEvent, HttpStatus.OK);
  }
}