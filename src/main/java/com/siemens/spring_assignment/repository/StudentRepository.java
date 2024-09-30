package com.siemens.spring_assignment.repository;

import com.siemens.spring_assignment.domains.entities.StudentEntity;
import com.siemens.spring_assignment.domains.entities.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

    boolean existsByEmail(String email);
//    @Query("SELECT DISTINCT s FROM StudentEntity s LEFT JOIN FETCH s.courses")
//    List<StudentEntity> findAllWithCourses();
//
//    @Query("SELECT s FROM StudentEntity s LEFT JOIN FETCH s.courses WHERE s.id = :id")
//    StudentEntity findByIdWithCourses(@Param("id") Long id);

}
