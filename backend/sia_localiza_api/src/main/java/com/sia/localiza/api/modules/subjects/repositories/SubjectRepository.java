package com.sia.localiza.api.modules.subjects.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sia.localiza.api.modules.subjects.entities.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, UUID> {
   Subject findByCode(String code);
}