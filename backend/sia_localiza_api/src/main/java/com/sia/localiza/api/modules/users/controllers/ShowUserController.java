package com.sia.localiza.api.modules.users.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sia.localiza.api.modules.users.entities.User;
import com.sia.localiza.api.modules.users.repositories.ShowUserRepository;


@RestController
@RequestMapping("/api/users/{id}")
public class ShowUserController {

  @Autowired
  private ShowUserRepository showUserRepository;

  
  @GetMapping()
  public ResponseEntity<User> handle(@PathVariable UUID  id) {
    return ResponseEntity.ok(showUserRepository.execute(id));
  }
}