package com.siemens.spring_assignment.repository;

import com.siemens.spring_assignment.domains.entities.StudentEntity;
import com.siemens.spring_assignment.domains.entities.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

    boolean existsByEmail(String email);
}
