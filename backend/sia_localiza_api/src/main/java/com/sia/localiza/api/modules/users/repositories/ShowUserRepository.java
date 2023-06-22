package com.sia.localiza.api.modules.users.repositories;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sia.localiza.api.modules.users.entities.User;

@Component
public class ShowUserRepository {
    @Autowired
    private UserRepository userRepository;
    
    public User execute(UUID id) {
        return this.userRepository.findById(id).get();
    }
}