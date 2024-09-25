package com.siemens.spring_assignment.domains.dtos;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public  class UserLoginDto {

    protected String email;
    protected String password;

}
