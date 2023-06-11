package com.sia.localiza.api.modules.events.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sia.localiza.api.modules.events.entities.Event;
import com.sia.localiza.api.modules.events.repositories.ListEventReposiotry;

import io.swagger.v3.oas.annotations.Hidden;

@RestController
@Hidden
@RequestMapping("/api/v1/events")
public class ListEventController {

  @Autowired
  private ListEventReposiotry listEventReposiotry;

  @GetMapping()
  public ResponseEntity<List<Event>> handle() {
    List<Event>  events = this.listEventReposiotry.execute();
    return new ResponseEntity<>(events, HttpStatus.OK);
  }
}