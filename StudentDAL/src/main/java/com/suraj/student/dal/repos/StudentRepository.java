package com.suraj.student.dal.repos;

import org.springframework.data.repository.CrudRepository;

import com.suraj.student.dal.entities.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {
	
	
	
}
