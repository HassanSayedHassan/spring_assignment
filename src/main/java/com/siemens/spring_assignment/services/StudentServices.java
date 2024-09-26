package com.siemens.spring_assignment.services;


import com.siemens.spring_assignment.domains.dtos.StudentDto;
import com.siemens.spring_assignment.domains.dtos.StudentDto;
import com.siemens.spring_assignment.domains.entities.CourseEntity;
import com.siemens.spring_assignment.domains.entities.StudentEntity;
import com.siemens.spring_assignment.domains.entities.StudentEntity;
import com.siemens.spring_assignment.mappers.Mapper;
import com.siemens.spring_assignment.repository.CourseRepository;
import com.siemens.spring_assignment.repository.StudentRepository;
import com.siemens.spring_assignment.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServices {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final Mapper<StudentEntity, StudentDto> studentMapper;
    @Autowired
    public StudentServices(StudentRepository studentRepository,
                           CourseRepository courseRepository,Mapper<StudentEntity, StudentDto> studentMapper) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.studentMapper = studentMapper;
    }


    public List<StudentDto> getAllStudents() {
        return studentRepository.findAll().stream().map(studentMapper::toDto).toList();
    }


    public boolean isEmailExists(String email) {
        return studentRepository.existsByEmail(email);
    }

    public StudentDto addStudent(StudentDto studentDto) {
        if(isEmailExists(studentDto.getEmail())){
            throw new IllegalArgumentException("Email already exists!");
        }
        studentDto.setRole("student");
        studentDto.setActive(true);
        StudentEntity studentEntity = studentMapper.toEntity(studentDto);
        return studentMapper.toDto(studentRepository.save(studentEntity));
    }

    public boolean deleteStudent(Long id) {
        Optional<StudentEntity> studentEntity = studentRepository.findById(id);
        if (studentEntity.isPresent()) {
            studentRepository.delete(studentEntity.get());
            return true;
        }
        return false;
    }

    public boolean updateStudent(Long id, StudentDto studentDto) {
        Optional<StudentEntity> studentEntity = studentRepository.findById(id);
        if (studentEntity.isPresent()) {
            if(studentDto.getFirstName() != null){
                studentEntity.get().setFirstName(studentDto.getFirstName());
            }

            if(studentDto.getLastName() != null){
                studentEntity.get().setLastName(studentDto.getLastName());
            }

            if(studentDto.getEmail() != null){
                studentEntity.get().setEmail(studentDto.getEmail());
            }

            if(studentDto.getPassword() != null){
                studentEntity.get().setPassword(studentDto.getPassword());
            }

            if(studentDto.getRole() != null){
                studentEntity.get().setRole(studentDto.getRole());
            }


            studentRepository.save(studentEntity.get());
            return true;
        }
        return false;
    }

    public StudentDto registerToCourse(Long studentId, Long courseId) {

        Optional<StudentEntity> studentEntity = studentRepository.findById(studentId);
        Optional<CourseEntity> courseEntity = courseRepository.findById(courseId);
        if (studentEntity.isPresent() && courseEntity.isPresent()) {
            studentEntity.get().getCourses().add(courseEntity.get());
            return studentMapper.toDto(studentRepository.save(studentEntity.get()));
        }
        throw new IllegalArgumentException("Student or Course not found");
    }
}
