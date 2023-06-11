package com.sia.localiza.api.modules.courses.repositories;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sia.localiza.api.modules.courses.entities.Course;


@Component
public class UpdateCourseRepository {
    @Autowired
    private CourseRepository courseRepository;
    
    public Course execute(UUID id, Course data) {
        data.setId(id);
        return this.courseRepository.save(data);
    }
}