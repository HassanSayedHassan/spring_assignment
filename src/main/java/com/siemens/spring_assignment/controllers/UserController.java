package com.siemens.spring_assignment.controllers;


import com.siemens.spring_assignment.domains.dtos.StudentDto;
import com.siemens.spring_assignment.domains.dtos.TeacherDto;
import com.siemens.spring_assignment.domains.dtos.UserLoginDto;
import com.siemens.spring_assignment.domains.entities.UserEntity;
import com.siemens.spring_assignment.domains.entities.UserEntity;
import com.siemens.spring_assignment.services.UserServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class UserController {

    private  UserServices userServices;

    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }
    @PostMapping("/login")
    public ResponseEntity< Optional<UserEntity>> login(@RequestBody UserLoginDto userLoginDto) {
        System.out.println("Email: " + userLoginDto.getEmail());
        System.out.println("Password: " + userLoginDto.getPassword());
        Optional<UserEntity> loggedUser = userServices.loginUser(userLoginDto);

        return loggedUser.map(user -> ResponseEntity.ok(loggedUser))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null));
    }

    @GetMapping("/teachers")
    public List<TeacherDto> getTeachers() {
        return userServices.getAllTeachers();
    }

    @GetMapping("/students")
    public List<StudentDto> getStudents() {
        return userServices.getAllStudents();
    }

    /*
        @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLoginDto userLoginDto) {
        System.out.println("Email: " + userLoginDto.getEmail());
        System.out.println("Password: " + userLoginDto.getPassword());

        // Assuming loginUser returns Optional<User>
        Optional<User> optionalUser = userServices.loginUser(userLoginDto);

        Map<String, Object> response = new HashMap<>();
        return optionalUser.map(user -> {
            response.put("status", "true");
            response.put("message", "Success login");
            response.put("user", user);
            return ResponseEntity.ok(response);
        }).orElseGet(() -> {
            response.put("status", "false");
            response.put("message", "Error happened in login");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        });
    }
    */



}
