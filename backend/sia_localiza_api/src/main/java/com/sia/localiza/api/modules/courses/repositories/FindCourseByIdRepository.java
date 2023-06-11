package com.sia.localiza.api.modules.courses.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sia.localiza.api.modules.courses.entities.Course;


@Component
public class FindCourseByIdRepository {
    @Autowired
    private CourseRepository courseRepository;
    
    public Optional<Course> execute(UUID id) {
        return this.courseRepository.findById(id);
    }
}