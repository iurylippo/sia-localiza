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
        var dayWeekFilter = dayWeek.isPresent() ? dayWeek.get().toString() : null;
        var dayPeriodFilter = dayPeriod.isPresent() ? dayPeriod.get().toString() : null;
        var professorIdFilter = professorId.isPresent() ? professorId.get().toString() : null;
        var subjectIdFilter = subjectId.isPresent() ? subjectId.get().toString() : null;
        var classNameFilter = className.isPresent() ? className.toString() : null;

        if(dayWeek.isPresent() && dayPeriod.isPresent() && (!professorId.isEmpty() || !subjectId.isEmpty())) {
            return this.campusEventRepository.findByFilters(
                dayWeekFilter,
                dayPeriodFilter,
                professorIdFilter,
                subjectIdFilter,
                classNameFilter
            );
        }
        
        return this.campusEventRepository.findAll();
    }
}