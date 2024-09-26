package com.siemens.spring_assignment.services;


import com.siemens.spring_assignment.domains.dtos.CourseDto;
import com.siemens.spring_assignment.domains.dtos.StudentDto;
import com.siemens.spring_assignment.domains.dtos.TeacherDto;
import com.siemens.spring_assignment.domains.dtos.UserLoginDto;
import com.siemens.spring_assignment.domains.entities.*;
import com.siemens.spring_assignment.domains.entities.UserEntity;
import com.siemens.spring_assignment.mappers.Mapper;
import com.siemens.spring_assignment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServices {

    private UserRepository userRepository;
    @Autowired
    public UserServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public Optional<UserEntity> loginUser(UserLoginDto userLoginDto) {
        return  userRepository.findByEmailAndPassword(userLoginDto.getEmail(), userLoginDto.getPassword());
    }


}
