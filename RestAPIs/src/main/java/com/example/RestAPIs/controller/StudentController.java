package com.example.RestAPIs.controller;

import com.example.RestAPIs.DTO.AddStudentRequestDTO;
import com.example.RestAPIs.DTO.StudentDTO;
import com.example.RestAPIs.entity.Student;
import com.example.RestAPIs.repository.StudentRepository;
import com.example.RestAPIs.service.StudentService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;


    @GetMapping("/students")
    public ResponseEntity<List<StudentDTO>> getStudents(){
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable Long id){
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @PostMapping("/students")
    public ResponseEntity<StudentDTO> createStudent(@RequestBody AddStudentRequestDTO studentRequestDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createNewStudent(studentRequestDTO));
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<Void> deleteStudentById(@PathVariable Long id){
        studentService.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<StudentDTO> updateStudent(@PathVariable Long id, @RequestBody AddStudentRequestDTO addStudentRequestDTO){
        return ResponseEntity.ok(studentService.updateStudent(id, addStudentRequestDTO));
    }

    @PatchMapping("/students/{id}")
    public ResponseEntity<StudentDTO> updatePartialStudent(@PathVariable Long id, @RequestBody Map<String, Object> map){
        return ResponseEntity.ok(studentService.updatePartialStudent(id, map));
    }

}
