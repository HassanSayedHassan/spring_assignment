package com.siemens.spring_assignment.controllers;


import com.siemens.spring_assignment.domains.dtos.TeacherDto;
import com.siemens.spring_assignment.services.TeacherServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/teacher")
public class TeacherController {

    private TeacherServices teacherServices;

    public TeacherController(TeacherServices teacherServices) {
        this.teacherServices = teacherServices;
    }

    @GetMapping()
    public List<TeacherDto> getTeachers() {
        return teacherServices.getAllTeachers();
    }

    @PostMapping()
    public ResponseEntity<?> addTeacher(@RequestBody TeacherDto teacherDto) {
        try {
            TeacherDto addedTeacher = teacherServices.addTeacher(teacherDto);
            return new ResponseEntity<>(addedTeacher, HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteTeacher(@RequestParam("id") Long id) {
        boolean teacherFound = teacherServices.deleteTeacher(id);
        if (teacherFound) {
            return ResponseEntity.ok("Teacher deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Teacher with id " + id + " not found");
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> updateTeacher(@PathVariable("id") Long id, @RequestBody TeacherDto teacherDto) {
        boolean teacherUpdated = teacherServices.updateTeacher(id, teacherDto);
        if (teacherUpdated) {
            return ResponseEntity.ok("Teacher updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Teacher with id " + id + " not found");
        }
    }
}
