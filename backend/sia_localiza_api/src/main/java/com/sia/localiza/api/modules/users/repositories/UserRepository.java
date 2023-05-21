package com.sia.localiza.api.modules.users.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sia.localiza.api.modules.users.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
   
}