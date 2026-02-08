package com.example.RestAPIs.service.impl;

import com.example.RestAPIs.DTO.AddStudentRequestDTO;
import com.example.RestAPIs.DTO.StudentDTO;
import com.example.RestAPIs.entity.Student;
import com.example.RestAPIs.repository.StudentRepository;
import com.example.RestAPIs.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<StudentDTO> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students
                .stream()
                .map(student -> modelMapper.map(student, StudentDTO.class))
                .toList();

    }

    @Override
    public StudentDTO getStudentById(Long id){
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student with id not found"));
        return modelMapper.map(student, StudentDTO.class);
    }

    @Override
    public StudentDTO createNewStudent(AddStudentRequestDTO addStudentRequestDTO){
        Student newStudent = modelMapper.map(addStudentRequestDTO, Student.class);
        Student student = studentRepository.save(newStudent);
        return modelMapper.map(student, StudentDTO.class);
    }

    @Override
    public void deleteStudentById(Long id){
        if(!studentRepository.existsById(id)){
            throw new IllegalArgumentException("Student not found");
        }
        studentRepository.deleteById(id);
        return;
    }

    @Override
    public StudentDTO updateStudent(Long id, AddStudentRequestDTO addStudentRequestDTO) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student with id: "+ id+ " not found to update"));
        modelMapper.map(addStudentRequestDTO, student);
        studentRepository.save(student);

        return modelMapper.map(student, StudentDTO.class);
    }

    @Override
    public StudentDTO updatePartialStudent(Long id, Map<String, Object> map) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student with id: "+ id+ " not found to update"));

        map.forEach((key, value) -> {
            switch(key) {
                case "name": student.setName((String) value); break;
                case "rollno": student.setRollno((int) value); break ;
                default:
                    throw new IllegalArgumentException("Field not supported");
            }
        });

        Student savedStudent = studentRepository.save(student);
        return modelMapper.map(student, StudentDTO.class);
    }
}
