package com.sia.localiza.api.modules.events.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sia.localiza.api.common.enums.EDayPeriod;
import com.sia.localiza.api.common.enums.EWeekDays;
import com.sia.localiza.api.modules.events.entities.CampusEvent;

@Repository
public interface CampusEventRepository extends JpaRepository<CampusEvent, UUID> {
        Optional<CampusEvent> findByEventIdAndProfessorIdAndSubjectIdAndClassName(UUID eventId, UUID professorId,
                        UUID subjectId, String className);

        @Query("from CampusEvent ce "
                        + "inner join ce.event e "
                        + "inner join ce.professor p "
                        + "inner join ce.subject s "
                        + "where e.dayWeek = :dayWeek "
                        + "and e.dayPeriod = :dayPeriod "
                        + "and (p.id = :professorId or s.id = :subjectId or ce.className = :className) ")
        List<CampusEvent> findByFilters(
                        @Param("dayWeek") Optional<EWeekDays> dayWeek,
                        @Param("dayPeriod") Optional<EDayPeriod> dayPeriod,
                        @Param("professorId") Optional<UUID> professorId,
                        @Param("subjectId") Optional<UUID> subjectId,
                        @Param("className") Optional<String> className);

        // @Query("from CampusEvent ce "
        // + "inner join ce.event e "
        // + "inner join ce.professor p "
        // + "inner join ce.subject s "
        // + "where e.dayWeek = ?1 "
        // + "and e.dayPeriod = ?2 "
        // + "and (p.id = ?3 or s.id = ?4 or ce.className = ?5) ")
        // List<CampusEvent> findByFilters(
        // @Param("dayWeek") Optional<EWeekDays> dayWeek,
        // @Param("dayPeriod") Optional<EDayPeriod> dayPeriod,
        // @Param("professorId") Optional<UUID> professorId,
        // @Param("subjectId") Optional<UUID> subjectId,
        // @Param("className") Optional<String> className);

        // @Query("select ce "
        // + "from campus_events ce "
        // + "inner join ce.event e "
        // + "inner join ce.professor p "
        // + "inner join ce.subject s "
        // + "where e.dayWeek = :dayWeek"
        // + "and e.dayPeriod = :dayPeriod"
        // + "and (p.id = :professorId or s.id = :subjectId or ce.className =
        // :className) ")
        // List<CampusEvent> findByFilters(
        // @Param("dayWeek") Optional<EWeekDays> dayWeek,
        // @Param("dayPeriod") Optional<EDayPeriod> dayPeriod,
        // @Param("professorId") Optional<UUID> professorId,
        // @Param("subjectId") Optional<UUID> subjectId,
        // @Param("className") Optional<String> className);
}