package com.sia.localiza.api.modules.events.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
  public ResponseEntity<List<CampusEvent>> handle() {
    List<CampusEvent>  events = this.listCampusEventReposiotry.execute();
    return new ResponseEntity<>(events, HttpStatus.OK);
  }
}