package com.siemens.spring_assignment.domains.dtos;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseDto {

    private Long id;
    private String name;

    private Date registrationDate;



}
