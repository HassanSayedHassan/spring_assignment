package com.siemens.spring_assignment.domains.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "student")
@NoArgsConstructor
@Setter
@Getter
public class StudentEntity extends UserEntity {


    @ManyToMany
    @JoinTable(
            name = "student_course", // Name of the join table
            joinColumns = @JoinColumn(name = "student_id"), // Foreign key for StudentEntity
            inverseJoinColumns = @JoinColumn(name = "course_id") // Foreign key for CourseEntity
    )
    private Set<CourseEntity> courses = new HashSet<>(); // List of courses the student is enrolled in

    public StudentEntity(UserEntity userEntity) {
        super(userEntity.getId(), userEntity.getFirstName(), userEntity.getLastName(), userEntity.getEmail(), userEntity.getPassword(), userEntity.isActive(), userEntity.getRole());
        this.courses=new HashSet<>();
    }
}
