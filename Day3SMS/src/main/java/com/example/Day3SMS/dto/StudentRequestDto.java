package com.example.Day3SMS.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class StudentRequestDto {
    @NotBlank(message = "name can not blank")
    private String name ;
    @Min(value =5 ,message = "age cannot be less than 5")
    @Max(value= 90,message = "age can not be more than 90")
    private int age;
    @Email(message = "Email should be valid ")
    @NotBlank(message = "email can not be blank")
    private String email;

    public StudentRequestDto() {
    }

    public StudentRequestDto(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
