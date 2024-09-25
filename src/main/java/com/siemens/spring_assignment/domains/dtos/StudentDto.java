package com.siemens.spring_assignment.domains.dtos;


import com.siemens.spring_assignment.domains.entities.CourseEntity;
import com.siemens.spring_assignment.domains.entities.StudentEntity;
import com.siemens.spring_assignment.domains.entities.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto extends UserDto {
    private String role;

    private List<CourseEntity> courses = new ArrayList<>();

}
