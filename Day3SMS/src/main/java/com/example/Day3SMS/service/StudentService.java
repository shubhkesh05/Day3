package com.example.Day3SMS.service;

import com.example.Day3SMS.dto.StudentRequestDto;
import com.example.Day3SMS.dto.StudentResponseDto;
import com.example.Day3SMS.exception.StudentNotFoundException;
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
//    public StudentModel addStudent(StudentModel student){
//        return repository.save(student);
//    }

    public StudentResponseDto addStudent(StudentRequestDto dto){
        StudentModel student = new StudentModel();
        student.setName(dto.getName());
        student.setAge(dto.getAge());
        student.setEmail(dto.getEmail());

        StudentModel saved = repository.save(student);

        return new StudentResponseDto(
                saved.getId(),
                saved.getName(),
                saved.getAge(),
                saved.getEmail()
        );
    }
    //Display Student
    public List<StudentModel> getStudents(){
        return repository.findAll();
    }
        public StudentResponseDto updateStudent(String id, StudentRequestDto dto) {
        StudentModel existingStudent = repository.findById(id)
            .orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + id));

        existingStudent.setName(dto.getName());
        existingStudent.setAge(dto.getAge());
        existingStudent.setEmail(dto.getEmail());

        StudentModel saved = repository.save(existingStudent);

        return new StudentResponseDto(
            saved.getId(),
            saved.getName(),
            saved.getAge(),
            saved.getEmail()
        );
        }

        public void deleteStudent(String id) {
        StudentModel existingStudent = repository.findById(id)
            .orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + id));

        repository.delete(existingStudent);
        }


}
