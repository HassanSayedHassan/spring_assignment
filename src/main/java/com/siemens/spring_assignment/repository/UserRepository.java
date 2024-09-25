package com.siemens.spring_assignment.repository;

import com.siemens.spring_assignment.domains.entities.TeacherEntity;
import com.siemens.spring_assignment.domains.entities.UserEntity;
import com.siemens.spring_assignment.domains.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface  UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmailAndPassword(String email, String password);
    List<UserEntity> findAllByRole(String role);
}
