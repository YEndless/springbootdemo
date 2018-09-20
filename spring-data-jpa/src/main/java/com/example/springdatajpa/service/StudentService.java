package com.example.springdatajpa.service;

import com.niit.springbootjpa.entity.Student;

import java.util.List;

public interface StudentService {
    Student save(Student student);

    List<Student> getAll();

    Student get(int id);

    void delete(int id);

}