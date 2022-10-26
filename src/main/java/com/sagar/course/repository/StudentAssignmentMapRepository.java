package com.sagar.course.repository;

import com.sagar.course.entity.StudentAssignmentMap;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentAssignmentMapRepository extends JpaRepository<StudentAssignmentMap, String> {

    List<StudentAssignmentMap> findByIsActiveTrue();

}
