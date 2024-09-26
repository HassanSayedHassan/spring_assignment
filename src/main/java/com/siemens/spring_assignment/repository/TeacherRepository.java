package com.siemens.spring_assignment.repository;

import com.siemens.spring_assignment.domains.entities.TeacherEntity;
import com.siemens.spring_assignment.domains.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<TeacherEntity, Long> {

    List<UserEntity> findAllByRole(String teacher);

    boolean existsByEmail(String email);

}
