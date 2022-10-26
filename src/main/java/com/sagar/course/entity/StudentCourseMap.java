package com.sagar.course.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "student_course_map")
public class StudentCourseMap {

    @GeneratedValue(strategy= GenerationType.AUTO)
    @Id
    @Column(name = "student_course_map_id")
    private String studentCourseMapId;

    @OneToOne
    @JoinColumn(name = "student_id")
    private StudentEntity studentEntity;

    @OneToOne
    @JoinColumn(name = "course_id")
    private CourseEntity courseEntity;

    @Column(name = "course_start_time")
    @UpdateTimestamp
    private LocalDateTime courseStartTime;

    @Column(name = "course_end_time")
    @UpdateTimestamp
    private LocalDateTime courseEndTime;

    @Column(name = "status")
    private String status;

    @Column(name = "active")
    private Boolean isActive;

    @JsonIgnore
    @Column(name = "created_by")
    private String createdBy;

    @JsonIgnore
    @Column(name = "updated_by")
    private String updatedBy;

}
