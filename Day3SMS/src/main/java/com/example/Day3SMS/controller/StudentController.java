package com.example.Day3SMS.controller;

import com.example.Day3SMS.dto.StudentRequestDto;
import com.example.Day3SMS.dto.StudentResponseDto;
import com.example.Day3SMS.model.StudentModel;
import com.example.Day3SMS.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
   private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }
//    Create function API
    @PostMapping("/add-student")
    public StudentResponseDto addStudent(@Valid @RequestBody StudentRequestDto student){
        return service.addStudent(student);
    }

@GetMapping("/students")
public List<StudentModel> getStudents(){
        return service.getStudents();
}
    @PutMapping("/update/{id}")
    public StudentResponseDto updateStudent(@PathVariable String id, @RequestBody StudentRequestDto student) {
        return service.updateStudent(id, student);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable String id) {
        service.deleteStudent(id);
        return "Student deleted successfully";
    }

}

