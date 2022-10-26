package com.sagar.course.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/assignment")
@Secured({"INSTRUCTOR"})
public class AssignmentController {

}
