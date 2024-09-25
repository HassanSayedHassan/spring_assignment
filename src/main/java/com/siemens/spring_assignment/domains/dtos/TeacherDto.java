package com.siemens.spring_assignment.domains.dtos;

import com.siemens.spring_assignment.domains.entities.TeacherEntity;
import com.siemens.spring_assignment.domains.entities.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDto extends UserDto {

    private String role;

}
