package com.sagar.course.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "assignment")
public class AssignmentEntity implements Serializable {

    @Id
    private String title;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdTs;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedTs;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "course_assignment", joinColumns = @JoinColumn(name = "assignment_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<CourseEntity> courseAssignment;

    @ManyToMany(mappedBy = "assignmentEnrollment", fetch = FetchType.EAGER)
    private Set<AppUserEntity> appUserEntities;
}
