package com.sagar.course.service.impl;

import com.sagar.course.entity.AppUserEntity;
import com.sagar.course.entity.AssignmentEntity;
import com.sagar.course.entity.CourseEntity;
import com.sagar.course.exception.RecordNotFoundException;
import com.sagar.course.repository.AppUserRepository;
import com.sagar.course.repository.AssignmentRepository;
import com.sagar.course.repository.CourseRepository;
import com.sagar.course.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    @Autowired
    AppUserRepository appUserRepository;


    @Autowired
    CourseRepository courseRepository;

    @Autowired
    AssignmentRepository assignmentRepository;

    /**
     * @param userName
     * @param courseTitle
     * @return
     */
    @Override
    public AppUserEntity enrollInCourse(String userName, String courseTitle) {
        Optional<AppUserEntity> appUserEntity = appUserRepository.findByAppUserId(userName);
        if (!appUserEntity.isPresent()) {
            throw new RecordNotFoundException(AppUserEntity.class.getSimpleName());
        }
        AppUserEntity user = appUserEntity.get();
        Optional<CourseEntity> courseOptional = courseRepository.findById(courseTitle);
        if (!courseOptional.isPresent()) {
            throw new RecordNotFoundException(CourseEntity.class.getSimpleName());
        }
        CourseEntity course = courseOptional.get();
        user.getCourseEnrollment().add(course);
        return appUserRepository.save(user);
    }

    /**
     * @param userName
     * @param courseTitle
     * @param assignmentTitle
     * @return
     */
    @Override
    public CourseEntity enrollAssignmentInCourse(String userName, String courseTitle, String assignmentTitle) {
        Optional<AssignmentEntity> assignmentOptional = assignmentRepository.findById(assignmentTitle);
        if (!assignmentOptional.isPresent()) {
            throw new RecordNotFoundException(AssignmentEntity.class.getSimpleName());
        }
        AssignmentEntity assignment = assignmentOptional.get();
        Optional<CourseEntity> courseOptional = courseRepository.findById(courseTitle);
        if (!courseOptional.isPresent()) {
            throw new RecordNotFoundException(CourseEntity.class.getSimpleName());
        }
        CourseEntity course = courseOptional.get();
        course.getAssignments().add(assignment);
        return courseRepository.save(course);
    }

    /**
     * @param userName
     * @param assignmentTitle
     * @return
     */
    @Override
    public AppUserEntity enrollInAssignment(String userName, String assignmentTitle) {
        Optional<AppUserEntity> appUserEntity = appUserRepository.findByAppUserId(userName);
        if (!appUserEntity.isPresent()) {
            throw new RecordNotFoundException(AppUserEntity.class.getSimpleName());
        }
        AppUserEntity user = appUserEntity.get();
        Optional<AssignmentEntity> assignmentOptional = assignmentRepository.findById(assignmentTitle);
        if (!assignmentOptional.isPresent()) {
            throw new RecordNotFoundException(AppUserEntity.class.getSimpleName());
        }
        AssignmentEntity assignmentEntity = assignmentOptional.get();
        user.getAssignmentEnrollment().add(assignmentEntity);
        return appUserRepository.save(user);
    }
}
