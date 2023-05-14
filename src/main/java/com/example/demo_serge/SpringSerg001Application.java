package com.example.demo_serge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringSerg001Application {

	public static void main(String[] args) {
		//SpringApplication.run(SpringSerg001Application.class, args);

		StudentRepository studentRepository = new StudentRepository();

		printStudents(studentRepository.ReadStudentsInfo());

		studentRepository.saveStudent(new Student("Boris A", 20));
		studentRepository.saveStudent(new Student("Dodik D", 30));

		printStudents(studentRepository.ReadStudentsInfo());

	}

	public static void printStudents(List<Student> studentList) {
		for(Student student : studentList) {
			System.out.println(student.getId() + " |\t" + student.getName() + " \t\t| " + student.getAge());
		}
	}

}
