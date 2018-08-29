package com.suraj.student.service;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.suraj.student.model.Course;
import com.suraj.student.model.Student;

@Component
public class StudentService {

	private static List<Student> students = new ArrayList<>();

	static {

		// Initialize Data

		Course course1 = new Course("Course1", "Spring", "10 Steps",
				Arrays.asList("Learn Maven", "Import Project", "First Example", "Second Example"));

		Course course2 = new Course("Course2", "Spring MVC", "10 Examples",
				Arrays.asList("Learn Maven", "Import Project", "First Example", "Second Example"));

		Course course3 = new Course("Course3", "Spring Boot", "6K Students",
				Arrays.asList("Learn Maven", "Learn Spring", "Learn Spring MVC", "First Example", "Second Example"));

		Course course4 = new Course("Course4", "Maven", "Most popular maven course on internet!",
				Arrays.asList("Pom.xml", "Build Life Cycle", "Parent POM", "Importing into Eclipse"));

		Student student_1 = new Student("Student1", "Suraj Pillutla", "Hiker, Programmer",
				new ArrayList<>(Arrays.asList(course1, course2, course3, course4)));

		Student student_2 = new Student("Student2", "Srishti Pillutla", "Hiker, Programmer",
				new ArrayList<>(Arrays.asList(course1, course2, course3, course4)));

		Student student_3 = new Student("Student3", "Uma Pillutla", "Hiker, Programmer",
				new ArrayList<>(Arrays.asList(course1, course2, course3)));

		students.add(student_1);
		students.add(student_2);
		students.add(student_3);

	}

	//
	public List<Student> retrieveCourses(String studentId) {
		return students;
	}

	//
	public Student retrieveStudentGivenId(String studentId) {
		for (Student student : students) {
			if (student.getId().equals(studentId)) {
				return student;
			}
		}
		return null;
	}

	//
	public List<Course> retrieveCoursesGivenStudentId(String studentId) {
		Student student = retrieveStudentGivenId(studentId);

		if (student == null) {
			return null;
		}

		return student.getCourses();
	}

	//
	public Course retrieveCourseGivenStudentIdAndCourseId(String studentId, String courseId) {
		Student student = retrieveStudentGivenId(studentId);

		if (student == null) {
			return null;
		}

		for (Course course : student.getCourses()) {
			if (course.getId().equals(courseId)) {
				return course;
			}
		}
		return null;
	}

	//
	private SecureRandom secureRandom = new SecureRandom();
	
	//
	public Course addCourse(String studentId, Course course) {
		Student student = retrieveStudentGivenId(studentId);

		if (student == null) {
			return null;
		}

		String randomId = new BigInteger(130, secureRandom).toString(3);
		course.setId(randomId);

		student.getCourses().add(course);

		return course;
	}

}
