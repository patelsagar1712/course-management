package com.sagar.course.service.impl;

import com.sagar.course.entity.AppUserEntity;
import com.sagar.course.entity.CourseEntity;
import com.sagar.course.repository.AppUserRepository;
import com.sagar.course.repository.CourseRepository;
import com.sagar.course.service.CourseService;
import com.sagar.course.service.UserService;
import com.sagar.course.util.ApplicationRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Date;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private AppUserRepository appUserRepository;


    /**
     * @param course
     * @return
     */
    @Override
    public CourseEntity saveCourse(CourseEntity course) {
        course.setCreatedTs(new Date());
        return courseRepository.save(course);
    }

    /**
     * @param principal
     * @return
     */
    @Override
    public Iterable<CourseEntity> getAllCourses(Principal principal) {
        AppUserEntity user = userService.getUserById(Integer.parseInt(principal.getName()));
        if (ApplicationRoles.INSTRUCTOR.getApplicationRoles().equalsIgnoreCase(user.getUserRole())) {
            return user.getCourseEnrollment();
        }
        return courseRepository.findAll();
    }

    /**
     * @param title
     * @param principal
     * @return
     */
    @Override
    public CourseEntity getCourse(String title, Principal principal) {
        return null;
    }

    /**
     * @param title
     * @param principal
     */
    @Override
    public void deleteCourse(String title, Principal principal) {

    }
}
