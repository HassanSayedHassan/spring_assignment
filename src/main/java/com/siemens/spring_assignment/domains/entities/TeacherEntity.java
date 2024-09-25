package com.siemens.spring_assignment.domains.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "teachers")
@NoArgsConstructor
@Setter
@Getter
public class TeacherEntity extends UserEntity {

    public TeacherEntity(UserEntity userEntity) {
        super(userEntity.getId(), userEntity.getFirstName(), userEntity.getLastName(), userEntity.getEmail(), userEntity.getPassword(), userEntity.isActive(), userEntity.getRole());
    }

}
