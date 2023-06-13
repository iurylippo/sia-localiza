package com.sia.localiza.api.modules.events.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sia.localiza.api.modules.events.entities.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, UUID> {
   Event findBySummary(String summary);

   @Query(value = "select e.* from events e "
   + "where e.summary = :summary "
   + "and e.day_week = CAST(:dayWeek as \"DayWeek\") "
   + "and e.day_period = CAST(:dayPeriod as \"DayPeriod\") "
   + "and e.start_at = CAST(:startAt as time) "
   + "and e.end_at = CAST(:endAt as time) ", nativeQuery = true)
   Optional<Event> findByUniqueKey(
      @Param("summary") String summary, 
      @Param("dayWeek") String dayWeek,  
      @Param("dayPeriod") String dayPeriod, 
      @Param("startAt") String startAt,  
      @Param("endAt") String endAt
   );
}