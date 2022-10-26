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
@Table(name = "student_assignment_map")
public class StudentAssignmentMap {

    @GeneratedValue(strategy= GenerationType.AUTO)
    @Id
    @Column(name = "student_assignment_id")
    private String studentAssignmentMapId;

    @OneToOne
    @JoinColumn(name = "student_id")
    private StudentEntity studentEntity;

    @OneToOne
    @JoinColumn(name = "assignment_id")
    private AssignmentEntity assignmentEntity;

    @Column(name = "assignment_start_time")
    @UpdateTimestamp
    private LocalDateTime assignmentStartTime;

    @Column(name = "assignment_end_time")
    @UpdateTimestamp
    private LocalDateTime assignmentEndTime;

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
