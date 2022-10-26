package com.sagar.course.repository;

import com.sagar.course.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<StudentEntity, String> {
    List<StudentEntity> findByIsActiveTrue();
}