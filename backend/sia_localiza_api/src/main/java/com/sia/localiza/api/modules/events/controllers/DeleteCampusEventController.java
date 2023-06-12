package com.sia.localiza.api.modules.events.controllers;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sia.localiza.api.modules.events.entities.CampusEvent;
import com.sia.localiza.api.modules.events.repositories.DeleteCampusEventRepository;
import com.sia.localiza.api.modules.events.repositories.FindCampusEventByIdRepository;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.EntityNotFoundException;

@RestController
@Hidden
@RequestMapping("/api/v1/events/campus/{id}")
public class DeleteCampusEventController {

  @Autowired
  private FindCampusEventByIdRepository findCampusEventByIdRepository;
  @Autowired
  private DeleteCampusEventRepository deleteCampusEventRepository;

  @DeleteMapping()
  public ResponseEntity<Void> handle(@PathVariable UUID id) {
    Optional<CampusEvent> campusEventExists = this.findCampusEventByIdRepository.execute(id);
    if(campusEventExists.isEmpty()) {
      throw new EntityNotFoundException();
    }

    this.deleteCampusEventRepository.execute(id);

    return new ResponseEntity<>(HttpStatus.OK);
  }
}