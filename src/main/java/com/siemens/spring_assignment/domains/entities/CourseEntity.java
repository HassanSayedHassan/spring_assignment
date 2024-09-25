package com.siemens.spring_assignment.domains.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "courses")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "courses") // This tells JPA that this side is inverse of the relationship
    private Set<StudentEntity> students = new HashSet<>(); // List of students enrolled in this course

    @Column(name = "registration_date")
    private Date registrationDate;
}
