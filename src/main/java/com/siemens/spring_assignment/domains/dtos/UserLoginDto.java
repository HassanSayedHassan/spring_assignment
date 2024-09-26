package com.siemens.spring_assignment.domains.dtos;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public  class UserLoginDto {

    protected String email;
    protected String password;

}
