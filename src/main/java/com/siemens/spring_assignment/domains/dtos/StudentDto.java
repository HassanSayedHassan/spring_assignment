package com.siemens.spring_assignment.domains.dtos;


import com.siemens.spring_assignment.domains.entities.CourseEntity;
import com.siemens.spring_assignment.domains.entities.StudentEntity;
import com.siemens.spring_assignment.domains.entities.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto extends UserDto {

    private Set<CourseEntity> courses = new HashSet<>();

}
