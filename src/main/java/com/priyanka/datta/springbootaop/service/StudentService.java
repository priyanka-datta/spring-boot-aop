package com.priyanka.datta.springbootaop.service;

import com.priyanka.datta.springbootaop.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAllStudents();

    Student findStudentById(Integer id);
}
