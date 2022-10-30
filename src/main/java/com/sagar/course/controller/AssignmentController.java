package com.sagar.course.controller;

import com.sagar.course.entity.AssignmentEntity;
import com.sagar.course.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/assignment")
@Secured({"INSTRUCTOR"})
public class AssignmentController {
    @Autowired
    AssignmentService assignmentService;

    @GetMapping
    public Iterable<AssignmentEntity> getAllAssignments() {
        return assignmentService.getAllAssignments();
    }

    @PostMapping("/{courseTitle}")
    public AssignmentEntity saveAssignment(@RequestBody AssignmentEntity assignment, @PathVariable("courseTitle") String courseTitle) {
        return assignmentService.saveAssignment(assignment);
    }

    @GetMapping("/{title}")
    public AssignmentEntity getAssignment(@PathVariable("title") String title) {
        return assignmentService.getAssignment(title);
    }

    @DeleteMapping("/{title}")
    public void deleteAssignment(@PathVariable("title") String title) {
        assignmentService.deleteAssignment(title);
    }

}
