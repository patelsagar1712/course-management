package com.sagar.course.repository;

import com.sagar.course.entity.AssignmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssignmentRepository extends JpaRepository<AssignmentEntity,String> {

    //List<AssignmentEntity> findByIsActiveTrue();
}
