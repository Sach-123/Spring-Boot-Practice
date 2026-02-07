package com.example.RestAPIs.repository;

import com.example.RestAPIs.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
