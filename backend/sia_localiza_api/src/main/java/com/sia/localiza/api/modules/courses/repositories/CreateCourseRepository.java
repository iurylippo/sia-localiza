package com.sia.localiza.api.modules.courses.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sia.localiza.api.modules.courses.entities.Course;


@Component
public class CreateCourseRepository {
    @Autowired
    private CourseRepository courseRepository;
    
    public Course execute(Course data) {
        return this.courseRepository.save(data);
    }
}