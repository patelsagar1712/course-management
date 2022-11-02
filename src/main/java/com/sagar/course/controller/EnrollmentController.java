package com.sagar.course.controller;

import com.sagar.course.entity.AppUserEntity;
import com.sagar.course.entity.CourseEntity;
import com.sagar.course.service.EnrollmentService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
@RestController
@SecurityRequirement(name = "Bearer Authentication")
@RequestMapping(path = "/enroll")
public class EnrollmentController {
    @Autowired
    EnrollmentService enrollmentService;

    @PostMapping(path = "/course/{courseTitle}")
    @Secured({"STUDENT"})
    public AppUserEntity enrollInCourse(Principal principal, @PathVariable("courseTitle") String courseTitle){
        return enrollmentService.enrollInCourse(principal.getName(), courseTitle);
    }

    @PostMapping(path = "/course/{courseTitle}/assignment/{assignmentTitle}")
    @Secured({"INSTRUCTOR"})
    public CourseEntity enrollAssignmentInCourse(Principal principal, @PathVariable("courseTitle") String courseTitle,
                                                 @PathVariable("assignmentTitle") String assignmentTitle){
        return enrollmentService.enrollAssignmentInCourse(principal.getName(), courseTitle, assignmentTitle);
    }

    @PostMapping(path = "/assignment/{assignmentTitle}")
    @Secured({"STUDENT"})
    public AppUserEntity enrollInAssignment(Principal principal, @PathVariable("assignmentTitle") String assignmentTitle){
        return enrollmentService.enrollInAssignment(principal.getName(), assignmentTitle);
    }
}
