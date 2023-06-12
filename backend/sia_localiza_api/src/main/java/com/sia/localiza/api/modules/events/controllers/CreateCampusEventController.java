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
import com.sia.localiza.api.modules.events.entities.CampusEvent;
import com.sia.localiza.api.modules.events.repositories.CreateCampusEventRepository;
import com.sia.localiza.api.modules.events.repositories.FindCampusEventByUniqueKeys;
import com.sia.localiza.api.modules.events.services.EnsureCampusEventRelationsExists;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.validation.Valid;

@RestController
@Hidden
@RequestMapping("/api/v1/events/campus")
public class CreateCampusEventController {

  @Autowired
  private CreateCampusEventRepository createCampusEventRepository;
  @Autowired
  private FindCampusEventByUniqueKeys findCampusEventByUniqueKeys;
  @Autowired
  private EnsureCampusEventRelationsExists ensureCampusEventRelationsExists;
  

  @PostMapping()
  public ResponseEntity<CampusEvent> handle(@Valid @RequestBody CampusEvent data) {
    this.ensureCampusEventRelationsExists.execute(data);

    Optional<CampusEvent> campusEventAlredyExists = this.findCampusEventByUniqueKeys.execute(data.getEventId(), data.getProfessorId(), data.getSubjectId(), data.getClassName());

    if(!campusEventAlredyExists.isEmpty()) {
       throw new BadRequestException("CampusEvent Relations combined(event_id,professor_id,subject_id,class) already exists!");
    }
    CampusEvent event = this.createCampusEventRepository.execute(data);
    return new ResponseEntity<>(event, HttpStatus.CREATED);
  }
}