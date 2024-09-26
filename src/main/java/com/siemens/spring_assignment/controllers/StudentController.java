package com.siemens.spring_assignment.controllers;


import com.siemens.spring_assignment.domains.dtos.StudentDto;
import com.siemens.spring_assignment.domains.dtos.StudentDto;
import com.siemens.spring_assignment.services.StudentServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/student")
public class StudentController {

    private StudentServices studentServices;

    public StudentController(StudentServices studentServices) {
        this.studentServices = studentServices;
    }

    @GetMapping("")
    public List<StudentDto> getStudents() {
        return studentServices.getAllStudents();
    }

    @PostMapping("")
    public ResponseEntity<?> addStudent(@RequestBody StudentDto studentDto) {
        try {
            StudentDto addedStudent = studentServices.addStudent(studentDto);
            return new ResponseEntity<>(addedStudent, HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("")
    public ResponseEntity<String> deleteStudent(@RequestParam("id") Long id) {
        boolean studentFound = studentServices.deleteStudent(id);
        if (studentFound) {
            return ResponseEntity.ok("Student deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student with id " + id + " not found");
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable("id") Long id, @RequestBody StudentDto studentDto) {
        boolean studentUpdated = studentServices.updateStudent(id, studentDto);
        if (studentUpdated) {
            return ResponseEntity.ok("Student updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student with id " + id + " not found");
        }
    }
    @PostMapping("registerToCourse")
    public ResponseEntity<String> registerToCourse(@RequestParam("student_id") Long studentId, @RequestParam("course_id") Long courseId) {
        try {
             studentServices.registerToCourse(studentId,courseId);
            return new ResponseEntity<>("Student registered successfully", HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
