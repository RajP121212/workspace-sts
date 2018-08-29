package com.suraj.student.dal;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.suraj.student.dal.entities.Student;
import com.suraj.student.dal.repos.StudentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentDalApplicationTests {

	@Autowired
	private StudentRepository studentRepository;

	@Test
	public void testCreateStudent() {

		Student student = new Student();
		student.setName("Suraj");
		student.setCourse("Spring Boot");
		student.setFee(10d);

		studentRepository.save(student);

	}

	@Test
	public void testFindStudentById() {

		Student student = studentRepository.findById(1l).get();
		System.out.println(student);

	}

	@Test
	public void testUpdateStudentById() {
		// we can use the save method to insert and to update

		Student student = studentRepository.findById(2l).get();
		student.setName("Srishti");

		studentRepository.save(student);
	}

	@Test
	public void testDeleteStudent() {

		Student student = new Student();
		student.setId(2l);

		studentRepository.delete(student);

	}

}
