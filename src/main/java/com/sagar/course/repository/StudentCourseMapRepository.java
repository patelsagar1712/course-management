package com.sagar.course.repository;

import com.sagar.course.entity.StudentCourseMap;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentCourseMapRepository extends JpaRepository<StudentCourseMap, String> {
    List<StudentCourseMap> findByIsActiveTrue();
}
