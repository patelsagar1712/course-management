package com.sagar.course.controller;

import com.sagar.course.entity.CourseEntity;
import com.sagar.course.service.CourseService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping(path = "/course")
@SecurityRequirement(name = "Bearer Authentication")
public class CourseController {


    @Autowired
    CourseService courseService;

    @GetMapping
    public Iterable<CourseEntity> getAllCourses(Principal principal) {
        return courseService.getAllCourses(principal);
    }

    @PostMapping(headers = HttpHeaders.AUTHORIZATION)
    @Secured({"INSTRUCTOR"})
    public CourseEntity saveCourse(@RequestBody CourseEntity course) {
        return courseService.saveCourse(course);
    }

    @GetMapping(path = "/{title}", headers = HttpHeaders.AUTHORIZATION)
    @Secured({"INSTRUCTOR", "SYSTEM_ADMIN", "STUDENT"})
    public CourseEntity getCourse(@Validated @PathVariable("title") String title, Principal principal) {
        return courseService.getCourse(title, principal);
    }

    @DeleteMapping(path = "/{title}", headers = HttpHeaders.AUTHORIZATION)
    @Secured({"INSTRUCTOR"})
    public void deleteCourse(@Validated @PathVariable("title") String title, Principal principal) {
        courseService.deleteCourse(title, principal);
    }
}
