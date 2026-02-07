package com.example.RestAPIs.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentDTO {
    private long id;
    private String name;
    private int rollno;
}
