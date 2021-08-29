package com.priyanka.datta.springbootaop.service.impl;

import com.priyanka.datta.springbootaop.entity.Student;
import com.priyanka.datta.springbootaop.exception.StudentNotFoundException;
import com.priyanka.datta.springbootaop.repository.StudentRepository;
import com.priyanka.datta.springbootaop.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> findAllStudents() {
        logger.info("Getting all the students");
        return studentRepository.findAll();
    }

    @Override
    public Student findStudentById(Integer id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (!optionalStudent.isPresent()){
            logger.error("No student present with id {}", id);
            throw new StudentNotFoundException("No student found with id : "+id);
        }
        return optionalStudent.get();
    }
}
