package com.siemens.spring_assignment.domains.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "student")
@NoArgsConstructor
@Data
public class StudentEntity extends UserEntity {


    @ManyToMany
    @JoinTable(
            name = "student_course", // Name of the join table
            joinColumns = @JoinColumn(name = "student_id"), // Foreign key for StudentEntity
            inverseJoinColumns = @JoinColumn(name = "course_id") // Foreign key for CourseEntity
    )
    private Set<CourseEntity> courses = new HashSet<>(); // List of courses the student is enrolled in


}
