package com.sagar.course.service.impl;

import com.sagar.course.entity.AssignmentEntity;
import com.sagar.course.repository.AssignmentRepository;
import com.sagar.course.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AssignmentServiceImpl implements AssignmentService {
    @Autowired
    AssignmentRepository assignmentRepository;

    public Iterable<AssignmentEntity> getAllAssignments() {
        return assignmentRepository.findAll();
    }

    public AssignmentEntity saveAssignment(AssignmentEntity assignment) {
        return assignmentRepository.save(assignment);
    }

    public AssignmentEntity getAssignment(String title) {
        Optional<AssignmentEntity> optionalAssignment = assignmentRepository.findById(title);
        return optionalAssignment.orElse(null);
    }

    public void deleteAssignment(String title) {
        assignmentRepository.deleteById(title);
    }
}
