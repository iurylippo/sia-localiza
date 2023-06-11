package com.sia.localiza.api.modules.events.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sia.localiza.api.modules.events.entities.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, UUID> {
   Event findBySummary(String summary);
}