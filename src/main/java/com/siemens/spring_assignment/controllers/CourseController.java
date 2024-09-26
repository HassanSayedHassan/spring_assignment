package com.siemens.spring_assignment.controllers;


import com.siemens.spring_assignment.domains.dtos.CourseDto;
import com.siemens.spring_assignment.services.CourseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {

    private CourseServices courseServices;

    @Autowired
    public CourseController(CourseServices courseServices) {
        this.courseServices = courseServices;
    }

    @PostMapping("/course")
    public CourseDto addCourse(@RequestParam("name") String name) {
        return courseServices.addCourse(name);
    }

    @GetMapping("/course")
    public List<CourseDto> addCourse() {
        return courseServices.getAllCourses();
    }

    //delete Course
    @DeleteMapping("/course")
    public ResponseEntity<String> deleteCourse(@RequestParam("id") Long id) {
        boolean courseFound = courseServices.deleteCourse(id);
        if (courseFound) {
            return ResponseEntity.ok("Course deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course with id " + id + " not found");
        }
    }

    @PatchMapping("/course/{id}")
    public ResponseEntity<String> updateCourse(@PathVariable("id") Long id, @RequestBody CourseDto courseDto) {
        boolean courseUpdated = courseServices.updateCourse(id, courseDto);
        if (courseUpdated) {
            return ResponseEntity.ok("Course updated successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course with id " + id + " not found.");
        }
    }

}
