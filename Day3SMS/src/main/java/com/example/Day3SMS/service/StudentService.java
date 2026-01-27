package com.example.Day3SMS.service;

import com.example.Day3SMS.model.StudentModel;
import com.example.Day3SMS.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    //    Create
    public StudentModel addStudent(StudentModel student){
        return repository.save(student);
    }
    //Display Student
    public List<StudentModel> getStudents(){
        return repository.findAll();
    }
    public StudentModel updateStudent(String id,StudentModel student){
        StudentModel existingStudent=repository.findById(id)
                .orElseThrow(() ->new RuntimeException("no student found"));
        existingStudent.setName(student.getName());
        existingStudent.setAge(student.getAge());
        existingStudent.setEmail(student.getEmail());
        return repository.save(existingStudent);
    }
    public void deleteStudent(String id) {
        StudentModel existingStudent = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        repository.delete(existingStudent);
    }


}
