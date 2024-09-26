package com.siemens.spring_assignment.domains.dtos;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public abstract class UserDto {

    protected Long id;
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String password;
    protected boolean active;
    protected String role;


}
