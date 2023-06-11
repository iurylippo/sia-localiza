package com.sia.localiza.api.modules.courses.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sia.localiza.api.modules.courses.entities.Course;


@Component
public class ListCourseReposiotry {
    @Autowired
    private CourseRepository courseRepository;
    
    public List<Course> execute() {
        return this.courseRepository.findAll();
    }
}