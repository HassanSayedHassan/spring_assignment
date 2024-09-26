package com.siemens.spring_assignment.domains.entities;

import jakarta.persistence.*;
import lombok.*;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    @Column(name = "id", updatable = false, nullable = false)
    protected Long id; // This is the primary key

    @Column(name = "first_name", nullable = false)
    protected String firstName;

    @Column(name = "last_name", nullable = false)
    protected String lastName;

    @Column(name = "email", nullable = false, unique = true)
    protected String email;

    @Column(name = "password", nullable = false)
    protected String password;

    @Column(name = "active", nullable = false)
    protected boolean active;

    @Column(name = "role", nullable = false)
    protected String role;
    // Additional constructors, methods, or validations can be added here
}
