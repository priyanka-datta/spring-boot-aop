package com.priyanka.datta.springbootaop.repository;

import com.priyanka.datta.springbootaop.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
}
