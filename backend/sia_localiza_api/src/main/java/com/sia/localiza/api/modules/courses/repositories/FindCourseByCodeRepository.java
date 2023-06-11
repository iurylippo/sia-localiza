package com.sia.localiza.api.modules.courses.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sia.localiza.api.modules.courses.entities.Course;


@Component
public class FindCourseByCodeRepository {
    @Autowired
    private CourseRepository courseRepository;
    
    public Course execute(String name) {
        return this.courseRepository.findByCode(name);
    }
}