package com.sia.localiza.api.modules.courses.repositories;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class DeleteCourseRepository {
    @Autowired
    private CourseRepository courseRepository;
    
    public void execute(UUID id) {
       this.courseRepository.deleteById(id);
    }
}