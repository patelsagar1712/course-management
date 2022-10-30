package com.sagar.course.repository;

import com.sagar.course.entity.AssignmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentRepository extends JpaRepository<AssignmentEntity, String> {


}
