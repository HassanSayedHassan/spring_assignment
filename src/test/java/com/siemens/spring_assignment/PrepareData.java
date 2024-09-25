package com.siemens.spring_assignment;


import com.siemens.spring_assignment.domains.entities.CourseEntity;
import com.siemens.spring_assignment.domains.entities.TeacherEntity;
import com.siemens.spring_assignment.domains.entities.UserEntity;
import com.siemens.spring_assignment.repository.CourseRepository;
import com.siemens.spring_assignment.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class PrepareData {

    private UserRepository userRepository;
    private CourseRepository courseRepository;
    @Autowired
    public PrepareData(UserRepository userRepository, CourseRepository courseRepository) {
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
    }

    @Test
    public void prepareCourseDb(){
        List<CourseEntity> result = courseRepository.findAll();
        System.out.println("Saved Courses: " + result.size());
        CourseEntity course=new CourseEntity();
        course.setName("Java");
        CourseEntity course1= courseRepository.save(course);
        CourseEntity course2= courseRepository.save(course);
        System.out.println("Saved Course: " + course1.getId());
        System.out.println("Saved Course: " + course2.getId());
        List<CourseEntity> result2 = courseRepository.findAll();
        System.out.println("Saved Courses: " + result2.size());
        assert true;
    }

    @Test
    public void getAllCourse() {
        List<CourseEntity> result = courseRepository.findAll();
        System.out.println("Saved Courses: " + result.size());
        assertThat(result).isNotNull(); // Check that the saved teacher is not null
    }

    @Test
    public void prepareTeacherDB() {
        // Create a new TeacherEntity
        TeacherEntity teacher = new TeacherEntity();
        teacher.setFirstName("John");
        teacher.setLastName("Doe");
        teacher.setEmail("johndoe@example.com"); // Use a valid email format
        teacher.setPassword("johndoe");
        teacher.setActive(true);
        teacher.setRole("teacher");

        // Save the teacher and capture the returned value
        TeacherEntity result = userRepository.save(teacher);
        System.out.println("Saved TeacherEntity: " + result);

        // Retrieve the saved entity using its ID
        TeacherEntity savedTeacher = (TeacherEntity) userRepository.findById(result.getId()).orElse(null);

        // Assertions to check if the saved data is as expected
        assertThat(savedTeacher).isNotNull(); // Check that the saved teacher is not null
        assertThat(savedTeacher.getFirstName()).isEqualTo("John"); // Check first name
        assertThat(savedTeacher.getLastName()).isEqualTo("Doe"); // Check last name
        assertThat(savedTeacher.getEmail()).isEqualTo("johndoe@example.com"); // Check email
        assertThat(savedTeacher.getRole()).isEqualTo("teacher"); // Check role
    }

    @Test
    public void getAllTeachers() {
        // Create a new TeacherEntity
        List<UserEntity> result = userRepository.findAll();
        System.out.println("Saved TeacherEntity: " + result);

        // Assertions to check if the saved data is as expected
        assertThat(result).isNotNull(); // Check that the saved teacher is not null
    }
}
