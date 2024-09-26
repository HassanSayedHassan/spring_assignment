package com.siemens.spring_assignment.services;


import com.siemens.spring_assignment.domains.dtos.StudentDto;
import com.siemens.spring_assignment.domains.dtos.TeacherDto;
import com.siemens.spring_assignment.domains.dtos.UserLoginDto;
import com.siemens.spring_assignment.domains.entities.StudentEntity;
import com.siemens.spring_assignment.domains.entities.TeacherEntity;
import com.siemens.spring_assignment.domains.entities.UserEntity;
import com.siemens.spring_assignment.mappers.Mapper;
import com.siemens.spring_assignment.repository.TeacherRepository;
import com.siemens.spring_assignment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherServices {

    private TeacherRepository teacherRepository;
    private Mapper<TeacherEntity, TeacherDto> teacherMapper;
    @Autowired
    public TeacherServices(TeacherRepository teacherRepository, Mapper<TeacherEntity, TeacherDto> teacherMapper) {
        this.teacherRepository = teacherRepository;
        this.teacherMapper = teacherMapper;
    }


    public List<TeacherDto> getAllTeachers() {
        return teacherRepository.findAll().stream().map(teacherMapper::toDto).toList();
    }

    // Check if the email already exists
    public boolean isEmailExists(String email) {
        return teacherRepository.existsByEmail(email);
    }

    public TeacherDto addTeacher(TeacherDto teacherDto) {
        if(isEmailExists(teacherDto.getEmail())){
            throw new IllegalArgumentException("Email already exists!");
        }
        teacherDto.setRole("teacher");
        teacherDto.setActive(true);
        TeacherEntity teacherEntity = teacherMapper.toEntity(teacherDto);
        return teacherMapper.toDto(teacherRepository.save(teacherEntity));
    }

    public boolean deleteTeacher(Long id) {
        Optional<TeacherEntity> teacherEntity = teacherRepository.findById(id);
        if (teacherEntity.isPresent()) {
            teacherRepository.delete(teacherEntity.get());
            return true;
        }
        return false;
    }

    public boolean updateTeacher(Long id, TeacherDto teacherDto) {
        Optional<TeacherEntity> teacherEntity = teacherRepository.findById(id);
        if (teacherEntity.isPresent()) {
            if(teacherDto.getFirstName() != null){
                teacherEntity.get().setFirstName(teacherDto.getFirstName());
            }

            if(teacherDto.getLastName() != null){
                teacherEntity.get().setLastName(teacherDto.getLastName());
            }

            if(teacherDto.getEmail() != null){
                teacherEntity.get().setEmail(teacherDto.getEmail());
            }

            if(teacherDto.getPassword() != null){
                teacherEntity.get().setPassword(teacherDto.getPassword());
            }

            if(teacherDto.getRole() != null){
                teacherEntity.get().setRole(teacherDto.getRole());
            }


            teacherRepository.save(teacherEntity.get());
            return true;
        }
        return false;
    }
}
