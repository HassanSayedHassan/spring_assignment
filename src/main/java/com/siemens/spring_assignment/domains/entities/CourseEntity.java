package com.siemens.spring_assignment.domains.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "courses")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "course",fetch = FetchType.LAZY)
    private Set<TeacherEntity> teachers;

   @ManyToMany(mappedBy = "courses")
    private Set<StudentEntity> students = new HashSet<>();

    @Column(name = "registration_date")
    private Date registrationDate;
}
