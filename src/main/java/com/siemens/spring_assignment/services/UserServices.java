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
    private Mapper<TeacherEntity, TeacherDto> teacherMapper;
    private Mapper<StudentEntity, StudentDto> studentMapper;
    @Autowired
    public UserServices(UserRepository userRepository, Mapper<TeacherEntity, TeacherDto> teacherMapper, Mapper<StudentEntity, StudentDto> studentMapper) {
        this.userRepository = userRepository;
        this.teacherMapper = teacherMapper;
        this.studentMapper = studentMapper;
    }
    public Optional<UserEntity> loginUser(UserLoginDto userLoginDto) {
        return  userRepository.findByEmailAndPassword(userLoginDto.getEmail(), userLoginDto.getPassword());
    }

    public List<TeacherDto> getAllTeachers() {
        List<UserEntity> result = userRepository.findAllByRole("teacher");
        List<TeacherEntity> teacherEntity = result.stream().map(TeacherEntity::new).toList();
        List<TeacherDto> teacherDtos = new ArrayList<>(teacherEntity.stream().map(teacherMapper::toDto).toList());
        return teacherDtos;
    }
    public List<StudentDto> getAllStudents() {
        List<UserEntity> result = userRepository.findAllByRole("student");
        List<StudentEntity> studentEntities = result.stream().map(StudentEntity::new).toList();
        List<StudentDto> studentDtos = new ArrayList<>(studentEntities.stream().map(studentMapper::toDto).toList());
        return studentDtos;
    }


}
