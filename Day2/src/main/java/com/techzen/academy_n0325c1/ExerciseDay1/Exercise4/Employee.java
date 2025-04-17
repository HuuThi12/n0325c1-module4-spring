package com.techzen.academy_n0325c1.ExerciseDay1.Exercise4;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

public class Employee {
    // (Universally Unique Identifier) là một kiểu dữ liệu dùng để biểu diễn một giá trị định danh duy nhất
    private UUID id;
    private String name;
    // DOB = Date of Birth
    private LocalDate DOB;
    private Gender gender ;
    private double salary;

    public enum Gender {
        // enum là một kiểu dữ liệu đặc biệt dùng để định nghĩa một tập hợp các hằng số.
        MALE,
        FEMALE,
        OTHER;
    }

    public Employee() {
    }

    public Employee(UUID id, String name, LocalDate DOB, Gender gender, double salary) {
        this.id = id;
        this.name = name;
        this.DOB = DOB;
        this.gender = gender;
        this.salary = salary;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
