package com.siemens.spring_assignment.domains.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "teachers")
@NoArgsConstructor
@Data
public class TeacherEntity extends UserEntity {


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private CourseEntity course;




}
