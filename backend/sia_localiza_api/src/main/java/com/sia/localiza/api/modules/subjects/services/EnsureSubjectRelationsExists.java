package com.sia.localiza.api.modules.subjects.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sia.localiza.api.common.exceptions.BadRequestException;
import com.sia.localiza.api.modules.courses.entities.Course;
import com.sia.localiza.api.modules.courses.repositories.FindCourseByIdRepository;
import com.sia.localiza.api.modules.subjects.entities.Subject;

@Service
public class EnsureSubjectRelationsExists {
    @Autowired
    private FindCourseByIdRepository findCourseByIdRepository;
   

    public void execute(Subject subject) {
        Optional<Course> courseExists = this.findCourseByIdRepository.execute(subject.getCouseId());
        
        if(courseExists.isEmpty()) {
            throw new BadRequestException("Course does not exists!");
        }    
    }
}
