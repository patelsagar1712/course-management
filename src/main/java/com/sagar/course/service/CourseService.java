package com.sagar.course.service;

import com.sagar.course.entity.CourseEntity;

import java.security.Principal;

public interface CourseService {

    CourseEntity saveCourse(CourseEntity course);

    Iterable<CourseEntity> getAllCourses(Principal principal);

    CourseEntity getCourse(String title, Principal principal);

    void deleteCourse(String title, Principal principal);
}
