package com.sagar.course.service;


import com.sagar.course.entity.AppUserEntity;
import com.sagar.course.entity.CourseEntity;

public interface EnrollmentService {
    AppUserEntity enrollInCourse(String userName, String courseTitle);

    CourseEntity enrollAssignmentInCourse(String userName, String courseTitle, String assignmentTitle);

    AppUserEntity enrollInAssignment(String userName, String assignmentTitle);
}
