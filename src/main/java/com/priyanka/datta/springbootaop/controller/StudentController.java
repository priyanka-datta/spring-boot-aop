package com.priyanka.datta.springbootaop.controller;

import com.priyanka.datta.springbootaop.entity.Student;
import com.priyanka.datta.springbootaop.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public List<Student> getAllStudents(){
       return studentService.findAllStudents();
    }

    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable Integer id){
        return studentService.findStudentById(id);
    }
}
