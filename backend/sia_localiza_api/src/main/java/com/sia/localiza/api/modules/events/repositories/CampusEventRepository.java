package com.sia.localiza.api.modules.events.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sia.localiza.api.modules.events.entities.CampusEvent;

@Repository
public interface CampusEventRepository extends JpaRepository<CampusEvent, UUID> {
    Optional<CampusEvent> findByEventIdAndProfessorIdAndSubjectIdAndClassName(UUID eventId, UUID professorId, UUID subjectId, String className);
}