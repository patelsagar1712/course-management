package com.sagar.course.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "course")
public class CourseEntity implements Serializable {
    @Id
    private String title;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdTs;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedTs;

    @ManyToMany(mappedBy = "courseEnrollment", fetch = FetchType.EAGER)
    private Set<AppUserEntity> emeritusUsers;

    @ManyToMany(mappedBy = "courseAssignment", fetch = FetchType.EAGER)
    private Set<AssignmentEntity> assignments;

}
