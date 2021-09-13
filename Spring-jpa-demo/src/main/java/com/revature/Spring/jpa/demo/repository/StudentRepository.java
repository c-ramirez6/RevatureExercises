package com.revature.Spring.jpa.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.revature.Spring.jpa.demo.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

	
		public List<Student> findByFirstName(String firstName);
		
		public List<Student> findByFirstNameContaining(String name);
		
		
		@Query("select s from Student s where s.emailAddress = ?1")
		public Student getStudentByEmailAddress(String email);
		
		@Query("select s.firstName from Student s where s.emailAddress = ?1")
		public String getStudentFirstNameByEmailAddress(String email);
		
		@Query(
				value = "SELECT * from students s where s.first_Name = ?1",
				nativeQuery = true
				)
		public Student getStudentByFirstNameNative(String firstName);
}
