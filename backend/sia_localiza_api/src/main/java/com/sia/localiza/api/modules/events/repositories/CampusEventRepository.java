package com.sia.localiza.api.modules.events.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sia.localiza.api.modules.events.entities.CampusEvent;

@Repository
public interface CampusEventRepository extends JpaRepository<CampusEvent, UUID> {
        Optional<CampusEvent> findByEventIdAndProfessorIdAndSubjectIdAndClassName(UUID eventId, UUID professorId,
                        UUID subjectId, String className);

        @Query(value = "select ce.* from campus_events ce "
                        + "inner join events e on (e.id = ce.event_id) "
                        + "inner join professors p on (p.id = ce.professor_id) "
                        + "inner join subjects s on (s.id = ce.subject_id) "
                        + "where e.day_week = CAST(:dayWeek as \"DayWeek\") "
                        + "and e.day_period = CAST(:dayPeriod as \"DayPeriod\") "
                        + "and (p.id = CAST(:professorId as uuid) or s.id = CAST(:subjectId as uuid) or ce.class = :className) ", nativeQuery = true)
        List<CampusEvent> findByFilters(
                        @Param("dayWeek") String dayWeek,
                        @Param("dayPeriod") String dayPeriod,
                        @Param("professorId") String professorId,
                        @Param("subjectId") String subjectId,
                        @Param("className") String className);
}