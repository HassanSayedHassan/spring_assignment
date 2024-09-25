package com.siemens.spring_assignment.config;

import com.siemens.spring_assignment.domains.entities.CourseEntity;
import com.siemens.spring_assignment.domains.entities.StudentEntity;
import com.siemens.spring_assignment.domains.entities.TeacherEntity;
import com.siemens.spring_assignment.repository.CourseRepository;
import com.siemens.spring_assignment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final UserRepository userRepository;
    private final CourseRepository courseRepository;

    @Autowired
    public DataLoader(UserRepository userRepository, CourseRepository courseRepository) {
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.count() == 0&&courseRepository.count()==0) {
            /* sava courses to the database*/
            courseRepository.save(CourseEntity.builder().name("java").registrationDate(new Timestamp(System.currentTimeMillis())).build());
            courseRepository.save(CourseEntity.builder().name("python").registrationDate(new Timestamp(System.currentTimeMillis())).build());
            courseRepository.save(CourseEntity.builder().name("c++").registrationDate(new Timestamp(System.currentTimeMillis())).build());


            /* sava Teacher to the database*/
            TeacherEntity teacher1 = new TeacherEntity();
            teacher1.setEmail("teacher1@example.com");
            teacher1.setPassword("password123");
            teacher1.setFirstName("John");
            teacher1.setLastName("Doe");
            teacher1.setActive(true);
            teacher1.setRole("teacher");
            userRepository.save(teacher1);

            TeacherEntity teacher2 = new TeacherEntity();
            teacher2.setEmail("teacher2@example.com");
            teacher2.setPassword("password456");
            teacher2.setFirstName("Emma");
            teacher2.setLastName("Brown");
            teacher2.setActive(true);
            teacher2.setRole("teacher");
            userRepository.save(teacher2);


            TeacherEntity teacher3 = new TeacherEntity();
            teacher3.setEmail("teacher3@example.com");
            teacher3.setPassword("password456");
            teacher3.setFirstName("Emma");
            teacher3.setLastName("Brown");
            teacher3.setActive(true);
            teacher3.setRole("teacher");
            userRepository.save(teacher3);

            StudentEntity student1 = new StudentEntity();
            student1.setEmail("student1@example.com");
            student1.setPassword("password123");
            student1.setFirstName("Alice");
            student1.setLastName("Smith");
            student1.setActive(true);
            student1.setRole("student");
            userRepository.save(student1);


            StudentEntity student2 = new StudentEntity();
            student2.setEmail("student2@example.com");
            student2.setPassword("password123");
            student2.setFirstName("Bob");
            student2.setLastName("Johnson");
            student2.setActive(true);
            student2.setRole("student");
            userRepository.save(student2);


            StudentEntity student3 = new StudentEntity();
            student3.setEmail("student3@example.com");
            student3.setPassword("password123");
            student3.setFirstName("Charlie");
            student3.setLastName("Davis");
            student3.setActive(true);
            student3.setRole("student");
            userRepository.save(student3);

        }
    }
}
