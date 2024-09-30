package com.siemens.spring_assignment.domains.dtos;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.siemens.spring_assignment.domains.entities.TeacherEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto {

    private Long id;
    private String name;
    @JsonIgnore  // Prevent recursion
    private Set<TeacherEntity>  teachers;
    @JsonIgnore  // Prevent recursion
    private Set<StudentDto> students;
    private Date registrationDate;



}
