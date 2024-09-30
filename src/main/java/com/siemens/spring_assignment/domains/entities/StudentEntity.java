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


    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH})
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<CourseEntity> courses = new HashSet<>(); // List of courses the student is enrolled in

   public void addCourse(CourseEntity course) {
        if(courses == null) {
            courses = new HashSet<>();
        }
        if(courses.contains(course)) {
            return;
        }
        courses.add(course);
    }

}
