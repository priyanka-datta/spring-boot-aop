package com.priyanka.datta.springbootaop;

import com.priyanka.datta.springbootaop.entity.Student;
import com.priyanka.datta.springbootaop.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootAopApplication implements CommandLineRunner {

	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Student student = new Student();
		student.setFirstName("Tania");
		student.setLastName("");
		student.setAddress("Chennai");
		Student student1 = new Student();
		student1.setFirstName("Rohan");
		student1.setLastName("");
		student1.setAddress("Bangalore");
		studentRepository.save(student);
		studentRepository.save(student1);
	}
}
