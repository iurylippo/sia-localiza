package com.sia.localiza.api.modules.events.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sia.localiza.api.common.enums.EDayPeriod;
import com.sia.localiza.api.common.enums.EWeekDays;
import com.sia.localiza.api.modules.events.entities.CampusEvent;
import com.sia.localiza.api.modules.events.repositories.ListCampusEventReposiotry;

import io.swagger.v3.oas.annotations.Hidden;

@RestController
@Hidden
@RequestMapping("/api/v1/events/campus")
public class ListCampusEventController {

  @Autowired
  private ListCampusEventReposiotry listCampusEventReposiotry;

  @GetMapping()
  public ResponseEntity<List<CampusEvent>> handle(
      @RequestParam("day_week") Optional<EWeekDays> dayWeek,
      @RequestParam("day_period") Optional<EDayPeriod> dayPeriod,
      @RequestParam("professor_id") Optional<UUID> professorId,
      @RequestParam("subject_id") Optional<UUID> subjectId,
      @RequestParam("class") Optional<String> className
    ) {
    List<CampusEvent>  events = this.listCampusEventReposiotry.execute(dayWeek, dayPeriod, professorId, subjectId, className);
    return new ResponseEntity<>(events, HttpStatus.OK);
  }
}