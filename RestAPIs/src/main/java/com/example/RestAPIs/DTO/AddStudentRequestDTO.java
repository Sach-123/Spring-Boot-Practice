package com.example.RestAPIs.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class AddStudentRequestDTO {
    private String name;
    private int rollno;
}
