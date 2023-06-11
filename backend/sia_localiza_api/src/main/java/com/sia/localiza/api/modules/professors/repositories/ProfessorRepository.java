package com.sia.localiza.api.modules.professors.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sia.localiza.api.modules.professors.entities.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, UUID> {
   Professor findByCode(String code);
}