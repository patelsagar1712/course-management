package com.sagar.course.service;

import com.sagar.course.entity.AssignmentEntity;

public interface AssignmentService {

    Iterable<AssignmentEntity> getAllAssignments();

    AssignmentEntity saveAssignment(AssignmentEntity assignment);

    AssignmentEntity getAssignment(String title);

    void deleteAssignment(String title);
}
