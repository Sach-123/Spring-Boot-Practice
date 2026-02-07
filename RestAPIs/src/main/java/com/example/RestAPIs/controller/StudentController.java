package com.example.RestAPIs.controller;

import com.example.RestAPIs.DTO.StudentDTO;
import com.example.RestAPIs.entity.Student;
import com.example.RestAPIs.repository.StudentRepository;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Data
public class StudentController {

    public StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return repository.findAll();
    }
}
