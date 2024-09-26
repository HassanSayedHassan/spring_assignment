package com.siemens.spring_assignment.services;


import com.siemens.spring_assignment.domains.dtos.CourseDto;
import com.siemens.spring_assignment.domains.entities.CourseEntity;
import com.siemens.spring_assignment.mappers.Mapper;
import com.siemens.spring_assignment.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServices {
    CourseRepository courseRepository;
    private Mapper<CourseEntity, CourseDto> courseMapper;
    @Autowired
    public CourseServices(CourseRepository courseRepository,Mapper<CourseEntity, CourseDto> courseMapper) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
    }
    public CourseDto addCourse(String name) {
        CourseEntity course = CourseEntity.builder().name(name).registrationDate(new Timestamp(System.currentTimeMillis())).build();
        CourseEntity res=courseRepository.save(course);
        return courseMapper.toDto(res);
    }

    public List<CourseDto> getAllCourses() {
        return courseRepository.findAll().stream().map(courseMapper::toDto).toList();
    }

    public boolean deleteCourse(Long id) {
        if (courseRepository.existsById(id)) {
            courseRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public boolean updateCourse(Long id, CourseDto courseDto) {
        Optional<CourseEntity> existingCourse = courseRepository.findById(id);

        if (existingCourse.isPresent()) {
            CourseEntity course = existingCourse.get();

            // Only update fields if they are provided in the DTO (non-null)
            if (courseDto.getName() != null) {
                course.setName(courseDto.getName());
            }
            if (courseDto.getRegistrationDate() != null) {
                course.setRegistrationDate(courseDto.getRegistrationDate());
            }
            // Add other fields to be updated as needed

            courseRepository.save(course); // Save the updated course to the database
            return true;
        } else {
            return false;
        }
    }
}
