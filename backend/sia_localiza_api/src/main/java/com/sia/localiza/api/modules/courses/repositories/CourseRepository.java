package com.sia.localiza.api.modules.courses.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sia.localiza.api.modules.courses.entities.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, UUID> {
   Course findByCode(String code);
}