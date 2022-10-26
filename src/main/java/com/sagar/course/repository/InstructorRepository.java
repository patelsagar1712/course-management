package com.sagar.course.repository;

import com.sagar.course.entity.InstructorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InstructorRepository extends JpaRepository<InstructorEntity, String> {
    List<InstructorEntity> findByIsActiveTrue();
}
