package com.sagar.course.repository;

import com.sagar.course.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<CourseEntity, String> {
    //List<CourseEntity> findByIsActiveTrue();
}
