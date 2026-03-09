package com.example.hospitalManagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(
        name = "patient",
        uniqueConstraints = {
                @UniqueConstraint(name = "unique_name", columnNames = {"email"}),
                @UniqueConstraint(name = "unique_name_and_dob", columnNames = {"name", "birthDate"})
        },
        indexes = {
                @Index(name = "idx_dob", columnList = "birthDate")
        }
)
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private LocalDate birthDate;

    private String email;
    private String bloodGroup;
    private String gender;

}
