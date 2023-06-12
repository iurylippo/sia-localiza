package com.sia.localiza.api.modules.events.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sia.localiza.api.common.enums.EDayPeriod;
import com.sia.localiza.api.common.enums.EWeekDays;
import com.sia.localiza.api.modules.events.entities.CampusEvent;


@Component
public class ListCampusEventReposiotry {
    @Autowired
    private CampusEventRepository campusEventRepository;
    
    public List<CampusEvent> execute(
       Optional<EWeekDays> dayWeek,
      Optional<EDayPeriod> dayPeriod,
      Optional<UUID> professorId,
      Optional<UUID> subjectId,
      Optional<String> className
    ) {
        if(dayWeek.isPresent() && !dayPeriod.isEmpty() && (!professorId.isEmpty() || !subjectId.isEmpty())) {
            return this.campusEventRepository.findByFilters(dayWeek, dayPeriod, professorId, subjectId, className);
        }
        return this.campusEventRepository.findAll();
    }
}