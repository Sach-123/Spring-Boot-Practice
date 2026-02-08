package com.example.RestAPIs.service;

import com.example.RestAPIs.DTO.AddStudentRequestDTO;
import com.example.RestAPIs.DTO.StudentDTO;
import com.example.RestAPIs.entity.Student;
import org.jspecify.annotations.Nullable;

import java.util.List;
import java.util.Map;

public interface StudentService {

    List<StudentDTO> getAllStudents();

    StudentDTO getStudentById(Long id);

    StudentDTO createNewStudent(AddStudentRequestDTO addStudentRequestDTO);

    void deleteStudentById(Long id);

    StudentDTO updateStudent(Long id, AddStudentRequestDTO addStudentRequestDTO);

    StudentDTO updatePartialStudent(Long id, Map<String, Object> map);
}
