package com.siemens.spring_assignment.controllers;


import com.siemens.spring_assignment.domains.dtos.CourseDto;
import com.siemens.spring_assignment.services.CourseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

}
